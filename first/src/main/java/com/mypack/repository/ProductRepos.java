package com.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mypack.models.Products;

@Repository
public interface ProductRepos extends JpaRepository<Products, Integer> 
{
	Products findById(int id);
   @Modifying(clearAutomatically = true)
    @Query("UPDATE Products p SET p.quantity = :quantity WHERE p.id = :id")
    void updateQuantity(int id, int quantity);
  
}
