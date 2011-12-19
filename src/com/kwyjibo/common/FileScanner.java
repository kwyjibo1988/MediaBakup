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

public class FileScanner implements FileScannerImpl {

	public FileScanner(String args){
		getTagData(args);
	}
	
	public void test(){
		System.out.println("FileScanner: active...");
	}

	@Override
	public void getTagData(String file) {
		File fl = new File(file);
		try {
			AudioFile f = AudioFileIO.read(fl);
			Tag tag = f.getTag();
			String artist = tag.getFirst(FieldKey.ARTIST);
			String title = tag.getFirst(FieldKey.TITLE);
			//String album = tag.getFirst(FieldKey.ALBUM);
			//System.out.println(artist + "-" + album + " - " + title);
		} catch (CannotReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				System.out.println(indent + f.getName());
				listDirectories(f, indent + " ");
			}
		}
	}	
}
