package com.kwyjibo.file.copier.util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import static java.nio.file.StandardCopyOption.*;

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
		
		Iterator<MusicFile> e = songs.iterator();
		while (e.hasNext()){
			MusicFile mf = e.next();
			Path source = Paths.get(mf.getPath());
			Path target = Paths.get(this.destination);
			Files.copy(source, target, COPY_ATTRIBUTES);
		}
		
	}
}
