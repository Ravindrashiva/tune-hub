package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Playlist;
import com.tunehub.entity.song;
import com.tunehub.service.PlaylistService;
import com.tunehub.service.SongService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
    List<song>songList=songService.fetchAllSongs();
    model.addAttribute("songs",songList);
		return "createPlaylist";
	}

    @PostMapping("/addPlaylist")
    public String addPlaylist(@ModelAttribute Playlist playlist) {
    	// updating playlist table
    	playlistService.addPlaylist(playlist);
    	// updating song table
    	List<song>songList =playlist.getSongs();
    	for(song s: songList) {
    		s.getPlaylist().add(playlist);
    		songService.updateSong(s);
    	}
    	return "adminHome";
    	
    }
    @GetMapping("/viewPlaylists")
    public String viewPlaylists(Model model){
    	
    	List<Playlist> allPlaylists=playlistService.fetchAllPlaylists();
    	model.addAttribute("AllPlaylists",allPlaylists);
        return "displayPlaylists";
    }
    
}