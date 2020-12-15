package com.mypack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.models.Cart;
@Repository
public interface CartRepos extends JpaRepository<Cart, Integer> {

	Cart findById(int id);
	List<Cart> findByuname(String uname);
	List<Cart> findBypid(int id);
	
}
