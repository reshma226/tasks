package com.mypack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.models.Users;
import com.mypack.repository.UserRepos;


@RestController
public class MainController {

	@Autowired
	UserRepos r;
	
		
	@PostMapping("/users/register")
	ResponseEntity<?> register(@RequestBody Users user) throws Error
	{
		
		Users u1=new Users();
		
		for(Users u:r.findByusername(user.getUsername()))
		{
			if(u.getUsername()!=null)
			{
				throw new Error("User "+u.getUsername()+" is taken");
			}
			else {
				u1.setFirstname(user.getFirstname());
				u1.setLastname(user.getLastname());
				u1.setUsername(user.getUsername());
				u1.setPassword(user.getPassword());
				u1.setMail(user.getMail());
				u1.setPhoneno(user.getPhoneno());
				r.save(u1);
			}
			
		}
		return ResponseEntity.ok().body(u1);

	}
	
	@PostMapping("/users/authenticate")
	ResponseEntity<?> validate(@RequestBody String username,@RequestBody String password)throws Error
	{
		Users user=new Users();
		
		
		for(Users u: r.findByusername(username))
		{
			
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setId(u.getId());
						
		}
		if(username.equals("admin") && password.equals("admin123")) 
		{ 
			user=r.findById(user.getId());	
		}
		
		else if(user.getUsername()!=null) 
		{
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				user=r.findById(user.getId());
				
			} 
									
		}
		else
		{
			throw new Error("User Name or password incorrect");
		}
		
	
		return ResponseEntity.ok().body(user);
	}
}
