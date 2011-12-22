package com.kwyjibo.file.creator.util;

public class MusicFile {
	private String album, artist, title;
	
	public MusicFile(String... data){
		this.album = data[0];
		this.artist = data[1];
		this.title = data[2];
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
