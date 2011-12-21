package com.kwyjibo.directory.util;

import java.io.File;

public interface DirectoryLister {
	
	void listDirectories(String path);
	
	void listDirectories(File dir, String indent);
}
