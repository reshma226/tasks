package com.mypack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepos extends JpaRepository<Users, Integer> 
{
 
	List<Users> findByusername(String username);
}
