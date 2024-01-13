package com.tunehub.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Playlist {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<song>songs;
	public Playlist() {
		super();
	
	}
	public Playlist(int id, String name, List<song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<song> getSongs() {
		return songs;
	}
	public void setSongs(List<song> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	}
	
	
}
