package com.kwyjibo.file.copier.util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.kwyjibo.file.creator.util.MusicFile;

public class FileCopier implements Copier {
	private String source, destination;
	private List<MusicFile> songs;

	public FileCopier(String destination, List<MusicFile> songs) {
		this.destination = destination;
		this.songs = songs;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public void copyFile() throws IOException {
		Path masterDir = Paths.get(this.destination);
		if (createMasterDirectory(masterDir)){
		    Iterator<MusicFile> e = songs.iterator();
		    while (e.hasNext()){
		        MusicFile mf = e.next();
		        Path albumArtistDir = Paths.get(this.destination + mf.getAlbumArtist());
		        Path albumDir = Paths.get(albumArtistDir.toString() + File.separator + mf.getAlbum());
		        if (createAlbumArtistDirectory(albumArtistDir)){
		        	if (createAlbumDirectory(albumDir)){
		        		Path source = Paths.get(mf.getPath());
				        Path target = Paths.get(albumDir + File.separator + mf.getFilename());
				        Files.copy(source, target);
		        	}
		        }
		    }
		}
	}
	
	@Override
	public boolean createMasterDirectory(Path masterDir) throws IOException{
		boolean exists = false;
		if (Files.exists(masterDir)
				&& Files.isDirectory((masterDir), LinkOption.NOFOLLOW_LINKS)){
			System.out.println("Master directory exists");
			exists = true;
		} else {
			Files.createDirectory(masterDir);
			System.out.println("Master directory created");
			exists = true;
		}
		return exists;
	}
	
	@Override
	public boolean createAlbumArtistDirectory(Path targetDir) throws IOException{
		boolean exists = false;
		if (Files.exists(targetDir) && Files.isDirectory((targetDir), LinkOption.NOFOLLOW_LINKS)){
			exists = true;
			System.out.println("Target directory exists");
		} else {
			Files.createDirectory(targetDir);
			exists = true;
			System.out.println("Target directory created");
		}
		return exists;
	}
	
	public boolean createAlbumDirectory(Path targetDir) throws IOException{
		boolean exists = false;
		if (Files.exists(targetDir) && Files.isDirectory((targetDir), LinkOption.NOFOLLOW_LINKS)){
			exists = true;
			System.out.println("Album directory exists");
		} else {
			Files.createDirectory(targetDir);
			exists = true;
			System.out.println("Album directory created");
		}
		return exists;
	}
}
