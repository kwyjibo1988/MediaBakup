package com.kwyjibo.directory.util;

import java.io.File;


public class DirectoryScanner implements DirectoryLister {
	private int directoryCount = 0;

	public int getDirectoryCount() {
		return directoryCount;
	}

	public void setDirectoryCount() {
		this.directoryCount++;
	}

	public DirectoryScanner() {
	
	}

	@Override
	public void listDirectories(String path){
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()){
			System.out.println("\nThat directory doesn't exist");
		} else {
			System.out.println("Scanning: " + dir.getPath());
			listDirectories(dir, " ");
		}
		System.out.println("Directory count: " + getDirectoryCount());
	}
	
	@Override
	public void listDirectories(File dir, String indent){
		File[] dirs = dir.listFiles();
		for (File f : dirs){
			if (f.isDirectory()){
				setDirectoryCount();
				//System.out.println(indent + f.getPath());
				listDirectories(f, indent + " ");
			}
		}
	}
}
