package com.example.first;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Repos extends CrudRepository<Users,Integer> {
    List<Users> findByusername(String username);
}
