package com.kwyjibo.file.tagger.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import com.kwyjibo.file.creator.util.MusicFile;


public class FileTagger implements Tagger {
	private String artist, title, album, path, filename, albumArtist;
	private List<MusicFile> songs = new ArrayList<>();
	private List<MusicFile> failed = new ArrayList<>();
	
	public FileTagger(){
		
	}
	
	@Override
	public void getTagData(File file) {
		try {
			AudioFile f = AudioFileIO.read(file);
			Tag tag = f.getTag();
			artist = tag.getFirst(FieldKey.ARTIST);
			title = tag.getFirst(FieldKey.TITLE);
			album = tag.getFirst(FieldKey.ALBUM);
			path = file.getPath();
			filename = file.getName();
			albumArtist = tag.getFirst(FieldKey.ALBUM_ARTIST);
			MusicFile mf = new MusicFile(album, artist, title, path, filename, albumArtist);
			if (!albumArtist.equals("")){
				songs.add(mf);
			} else {
				failed.add(mf);
				//System.out.println("File: " + file.getAbsolutePath() + " did not contain album artist");
			}
		} catch (CannotReadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getMusicTags(List<File> files) {
		Iterator<File> e = files.iterator();
		while (e.hasNext()){
			getTagData(e.next());
		}
	}

	@Override
	public void printSongs() {
		Iterator<MusicFile> e = songs.iterator();
		while (e.hasNext()){
			MusicFile mf = e.next();
			System.out.println(mf.getFilename() + " " + mf.getAlbumArtist());
			//System.out.println(mf.getArtist() + " " + mf.getTitle() + " " + mf.getAlbum() + " " + mf.getPath() + " " + mf.getAlbumArtist());
		}
		System.out.println("-------------------------------------");
		System.out.println("Music files stored: " + songs.size());
	}
	
	

	public List<MusicFile> getSongs() {
		return songs;
	}
	
	public List<MusicFile> getFailed() {
		return failed;
	}

	@Override
	public void printFailedSongs() {
		Iterator<MusicFile> e = failed.iterator();
		System.out.println("\nFailed files:");
		while (e.hasNext()){
			MusicFile mf = e.next();
			System.out.println(mf.getPath());
		}
		System.out.println("-------------------------------------");
		System.out.println("Music files failed: " + failed.size());
	}
}
