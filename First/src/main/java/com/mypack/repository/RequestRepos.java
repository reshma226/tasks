package com.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypack.models.Requests;

public interface RequestRepos extends JpaRepository<Requests, Integer>
{
	Requests findById(int id);
}
