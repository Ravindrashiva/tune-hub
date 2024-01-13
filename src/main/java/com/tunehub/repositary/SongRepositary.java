package com.tunehub.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.song;

public interface SongRepositary extends JpaRepository<song, Integer>{

public song findByName(String name);
}
