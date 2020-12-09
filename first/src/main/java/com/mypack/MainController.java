package com.mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	@Autowired
	UserRepos r;
			
	@RequestMapping("/")
	public String first()
	{
				
		return "Login.jsp";
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam("fname") String fn,@RequestParam("lname") String ln,@RequestParam("name") String n,@RequestParam("password") String p,@RequestParam("mail") String m,@RequestParam("ph") long ph)
	{
		long id=r.count();
		id=id+1;
		Users u=new Users(id,n,fn,ln,p,m,ph);
		r.save(u);
		return "Login.jsp";
	}
	
	@RequestMapping("/login")
	
	public ModelAndView validate(@RequestParam("name") String name,@RequestParam("password") String p,ModelAndView m)
	{
		Users u1= new Users();
		String s1=null,s2=null;
		if(name.equals("admin") && p.equals("admin123")) 
		{ 
		u1.setUsername(name);
		m.addObject("name", name);
		m.setViewName("admin.jsp");
		return m;
		}
		else {
		for(Users u: r.findByusername(name))
		{
			
			s1=u.getUsername();
			s2=u.getPassword();
			
		}
		
		if(s1!=null) 
		{
			if(s1.equals(name) && s2.equals(p))
			{
				u1.setUsername(name);
				m.addObject("name", name);
				m.setViewName("user.jsp");
				
				
			}
			else {
				m.addObject("error", "Invalid credentials");
				m.setViewName("Login.jsp");
			}
		}
		else {
			m.addObject("error", "User does not exist");
			m.setViewName("Login.jsp");
		}
		return m;
		
	}
	}
}
