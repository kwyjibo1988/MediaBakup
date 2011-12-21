package com.kwyjibo.file.scanner.util;

import java.io.File;
import java.util.List;

public interface Scanner {
	
	void listFiles(List<File> directories);
	
	void printFiles();
}
