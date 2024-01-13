package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.song;
import com.tunehub.service.SongService;

@Controller

public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public  String addSong(@ModelAttribute song song) {
		boolean songStatus = service.songExists(song.getName());
		if(songStatus == false) {
			service.addSong(song);
			System.out.println("song added successfully");
		}
		else {
			System.out.println("song already exists");
		}
			return"adminhome";
			
		
		
		}
	@GetMapping("/playSongs")
	public  String playSongs(Model model) {
		boolean premiuser = true;
		if(premiuser == false) {
		List<song>songsList = service.fetchAllSongs();
		model.addAttribute("songs", songsList);
		return "displaySongs";
		}
		else {
			return "makePayment";
		}
	}
}
