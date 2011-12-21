package com.kwyjibo.directory.util;

import java.io.File;


public class DirectoryScanner implements DirectoryLister {

	public DirectoryScanner(String string) {
		listDirectories(string);
	}

	@Override
	public void listDirectories(String path){
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()){
			System.out.println("\nThat directory doesn't exist");
		} else {
			System.out.println("\nListing directory tree of: ");
			System.out.println(dir.getPath());
			listDirectories(dir, " ");
		}
	}
	
	@Override
	public void listDirectories(File dir, String indent){
		File[] dirs = dir.listFiles();
		for (File f : dirs){
			if (f.isDirectory()){
				System.out.println(indent + f.getPath());
				listDirectories(f, indent + " ");
			}
		}
	}

}
