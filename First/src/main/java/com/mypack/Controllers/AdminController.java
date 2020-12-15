package com.mypack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.models.Products;
import com.mypack.models.Requests;
import com.mypack.models.Users;
import com.mypack.repository.ProductRepos;
import com.mypack.repository.RequestRepos;
import com.mypack.repository.UserRepos;

@RestController
public class AdminController {

	@Autowired
	UserRepos ur;
	@Autowired
	ProductRepos pr;
	@Autowired
	RequestRepos rr;
	
	
	@GetMapping("/users")
	public List<Users> userList()
	{
				
		return this.ur.findAll();
	}
	
	@DeleteMapping("/users/{id}")
	ResponseEntity<?> deleteUser(@PathVariable("id")long id)
	{
			ur.deleteById(id);
			return ResponseEntity.ok().build();
	}
	
	@GetMapping("/products")
	public List<Products> productList()
	{
		return this.pr.findAll();
	}
	
	@GetMapping("/requests")
	public List<Requests> requestList(Model m)
	{
		return this.rr.findAll();
	}
	@DeleteMapping("/requests/approve/{id}")
	ResponseEntity<?> approveRequest(Model m,@RequestParam("id")int id)
	{
		
			Requests r1=rr.findById(id);
			
			Products p=pr.findById(r1.getPid());
			p.setQuantity(p.getQuantity()+(2*r1.getQuantity()));
			pr.save(p);
			rr.deleteById(id);
			 return ResponseEntity.ok().build();
	}
	@DeleteMapping("/requests/reject/{id}")
	ResponseEntity<?> deleteRequest(@PathVariable("id")int id) {
		rr.deleteById(id);
		return ResponseEntity.ok().build();

	}
	
}
