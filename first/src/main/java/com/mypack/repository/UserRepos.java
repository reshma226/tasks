package com.mypack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.models.Users;
@Repository
public interface UserRepos extends JpaRepository<Users, Long> 
{
 
	List<Users> findByusername(String username);
	 }
