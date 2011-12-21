package com.kwyjibo.directory.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DirectoryScanner implements DirectoryLister {
	private int directoryCount = 0;
	List<String> directories = new ArrayList<>();
	
	public DirectoryScanner() {
		
	}

	public List<String> getDirectories() {
		return directories;
	}

	public int getDirectoryCount() {
		return directoryCount;
	}

	public void setDirectoryCount() {
		this.directoryCount++;
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
		printDirectories();
	}
	
	@Override
	public void listDirectories(File dir, String indent){
		File[] dirs = dir.listFiles();
		for (File f : dirs){
			if (f.isDirectory()){
				setDirectoryCount();
				String dp = f.getPath();
				directories.add(dp);
				//System.out.println(indent + f.getPath());
				listDirectories(f, indent + " ");
			}
		}
	}
	
	public void printDirectories(){
		Iterator<String> e = directories.iterator();
		while (e.hasNext()){
			String path = e.next();
			System.out.println(path);
		}
		System.out.println("-------------------------------------");
		System.out.println("Directories counted: " + getDirectoryCount());
		System.out.println("Directories stored: " + directories.size());	
	}
}
