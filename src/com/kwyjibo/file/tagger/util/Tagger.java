package com.kwyjibo.file.tagger.util;

import java.io.File;
import java.util.List;


public interface Tagger {
	
	void getTagData(File file);
	
	void getMusicTags(List<File> files);
	
	void printSongs();
	
	void printFailedSongs();
}
