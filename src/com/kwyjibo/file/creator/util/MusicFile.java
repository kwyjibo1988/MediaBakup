package com.kwyjibo.file.creator.util;

public class MusicFile {
	private String album, artist, title, path, filename;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MusicFile(String... data){
		this.album = data[0];
		this.artist = data[1];
		this.title = data[2];
		this.path = data[3];
		this.setFilename(data[4]);
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
