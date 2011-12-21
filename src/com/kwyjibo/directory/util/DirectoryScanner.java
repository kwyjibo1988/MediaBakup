package com.kwyjibo.directory.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DirectoryScanner implements Scanner {
	private int directoryCount = 0;
	List<File> directories = new ArrayList<>();
	
	public DirectoryScanner() {
		
	}

	public List<File> getDirectories() {
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
	}
	
	@Override
	public void listDirectories(File dir, String indent){
		File[] dirs = dir.listFiles();
		for (File f : dirs){
			if (f.isDirectory()){
				setDirectoryCount();
				directories.add(f);
				//System.out.println(indent + f.getPath());
				listDirectories(f, indent + " ");
			}
		}
	}
	
	@Override
	public void printDirectories(){
		Iterator<File> e = directories.iterator();
		while (e.hasNext()){
			String path = e.next().getPath();
			System.out.println(path);
		}
		System.out.println("-------------------------------------");
		System.out.println("Directories counted: " + getDirectoryCount());
		System.out.println("Directories stored: " + directories.size());	
	}
}
