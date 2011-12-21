package com.kwyjibo.common;
import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class FileScanner implements DirectoryScanner {
	private int directoryCount = 0;

	public FileScanner(String args){
		listDirectories(args);
	}

	private void listDirectories(String path){
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()){
			System.out.println("\nThat directory doesn't exist");
		} else {
			System.out.println("\nListing directory tree of: ");
			System.out.println(dir.getPath());
			listDirectories(dir, " ");
		}
	}
	
	private void listDirectories(File dir, String indent){
		File[] dirs = dir.listFiles();
		for (File f : dirs){
			if (f.isDirectory()){
				System.out.println(indent + f.getPath());
				listDirectories(f, indent + " ");
			}
		}
	}	
}
