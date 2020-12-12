package com.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.models.Products;

@Repository
public interface ProductRepos extends JpaRepository<Products, Integer> 
{
	Products findById(int id);
  
}
 