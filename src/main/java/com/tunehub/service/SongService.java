package com.tunehub.service;

import java.util.List;

import com.tunehub.entity.song;

public interface SongService {

	public void addSong(song song);

	public List<song> fetchAllSongs();

	public boolean songExists(String name);
	
	public void updateSong(song song);

}

