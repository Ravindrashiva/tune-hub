package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.song;
import com.tunehub.repositary.SongRepositary;

@Service
public class SongServiceImplementation  implements SongService{
	@Autowired
	SongRepositary  repo;
	@Override
	public void addSong(song song) {
		repo.save(song);
		}
	public List<song> fetchAllSongs() {
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) {
		song song = repo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public void updateSong(song song) {
		repo.save(song);
		
	}
}
