package com.tunehub.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.Playlist;

public interface PlaylistRepositary extends JpaRepository<Playlist, Integer>
{

}
