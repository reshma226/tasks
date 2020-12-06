package com.example.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController 
{
    @Autowired
	Repos r;
	
		
    @RequestMapping("/")
	public String first()
	{
		return "Login";
	}
	
/*	@RequestMapping("/Register")
	public void register(Users u)
	{
		r.save(u);
	}
*/	
	@RequestMapping("/login-validate")
	@ResponseBody
	public String validate(@RequestParam("username") String name,@RequestParam("password") String p)
	{
		Users v1=(Users)r.findByusername(name);
		String s1=v1.getUsername();
		String s2=v1.getPassword();
		if(s1.equals(name) && s2.equals(p))
			return "login";
		else if(s1.equals(name))
			return "Incorrect password";
		else
			return "User not exists";
		
		
	}
   
}
