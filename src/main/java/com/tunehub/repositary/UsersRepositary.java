  package com.tunehub.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.Users;

public interface UsersRepositary extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);
}
