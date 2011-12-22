package com.kwyjibo.file.creator.util;

public class MusicFile {
	private String album, artist, title, path, filename, albumArtist;
	
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
		this.filename = data[4];
		this.albumArtist = data[5];
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

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
}
