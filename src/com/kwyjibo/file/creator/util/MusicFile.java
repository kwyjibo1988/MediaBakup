package com.kwyjibo.file.creator.util;

public class MusicFile {
	private String album, artist, title, path;
	
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
}
