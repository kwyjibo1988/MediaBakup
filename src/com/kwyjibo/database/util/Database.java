package com.kwyjibo.database.util;

import java.net.UnknownHostException;
import java.util.List;

import com.kwyjibo.file.creator.util.MusicFile;
import com.mongodb.MongoException;

public interface Database {
	
	void connect() throws UnknownHostException, MongoException;
	
	void populateFailed(List<MusicFile> failed);

}
