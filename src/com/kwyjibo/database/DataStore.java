package com.kwyjibo.database;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DataStore {
	private DB db;
	
	public DataStore() {
		try {
			connect();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		insertObject();
	}
	
	private void connect() throws UnknownHostException, MongoException{
		Mongo m = new Mongo();
		db = m.getDB("mydb");
	}
	
	private void insertObject(){
		DBCollection coll = db.getCollection("testCollection");
		BasicDBObject doc = new BasicDBObject();

        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);

        doc.put("info", info);

        coll.insert(doc);
        
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);
	}

}
