package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Playlist;
import com.tunehub.repositary.PlaylistRepositary;

@Service

public class  PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
    PlaylistRepositary repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		return repo.findAll();
	}
	}
