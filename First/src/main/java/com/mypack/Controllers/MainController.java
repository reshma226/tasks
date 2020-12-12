package com.mypack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mypack.models.Users;
import com.mypack.repository.UserRepos;


@Controller
public class MainController {

	@Autowired
	UserRepos r;
	public static String uname;
	
	
	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		MainController.uname = uname;
	}

	@RequestMapping("/")
	public String first()
	{
				
		return "Login.jsp";
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam("firstName") String fn,@RequestParam("lastName") String ln,@RequestParam("username") String n,@RequestParam("password") String p,@RequestParam("mail") String m,@RequestParam("phoneno") long ph)
	{
		long id=r.count();
		id=id+1;
		Users u=new Users(id,n,fn,ln,p,m,ph);
		r.save(u);
		System.out.println(u);
		return "Login.jsp";
	}
	
	@RequestMapping("/login")
	public ModelAndView validate(@RequestParam("username") String name,@RequestParam("password") String p)
	{
		ModelAndView m=new ModelAndView();
		String s1=null,s2=null;
		if(name.equals("admin") && p.equals("admin123")) 
		{ 
		setUname(name);
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
				System.out.println(name);
				setUname(name);
				System.out.println(name);
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
		System.out.println(uname);
		return m;
		
	}
		
	}
}
