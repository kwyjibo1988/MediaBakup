package com.kwyjibo.database.util;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import com.kwyjibo.file.creator.util.MusicFile;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DataStore implements Database {
	private DB db;
	private DBCollection coll;
	
	public DataStore() {
		try {
			connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect() throws UnknownHostException, MongoException{
		Mongo m = new Mongo();
		db = m.getDB("failed");
		coll = db.getCollection("failedFiles");
	}

	@Override
	public void populateFailed(List<MusicFile> failed) {		
		Iterator<MusicFile> e = failed.iterator();
		while (e.hasNext()){
			MusicFile mf = e.next();
			BasicDBObject doc = new BasicDBObject();
			doc.put("artist", mf.getArtist());
			doc.put("albumArtist", mf.getAlbumArtist());
			doc.put("title", mf.getTitle());
			doc.put("album", mf.getAlbum());
			doc.put("path", mf.getPath());
			doc.put("fileName", mf.getFilename());
			coll.insert(doc);
		}
	}
}
