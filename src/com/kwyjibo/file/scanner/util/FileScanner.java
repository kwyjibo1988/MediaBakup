package com.kwyjibo.file.scanner.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileScanner implements Scanner {
	private List<File> files = new ArrayList<>();
	private int fileCount = 0;
	
	public FileScanner(){
		
	}
	
	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount() {
		this.fileCount++;
	}

	public List<File> getFiles() {
		return files;
	}

	@Override
	public void listFiles(List<File> directories) {
		
		FilenameFilter filter = new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".m4a") || name.endsWith(".mp3");
		    }
		};
		
		Iterator<File> e = directories.iterator();
		while (e.hasNext()){
			File[] nested = e.next().listFiles(filter);
			for (File f : nested){
				files.add(f);
				setFileCount();
			}
		}
	}

	@Override
	public void printFiles() {
		Iterator<File> e = files.iterator();
		while (e.hasNext()){
			System.out.println(e.next().getName());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("Files counted: " + getFileCount());
		System.out.println("Files stored: " + files.size());
	}
}
