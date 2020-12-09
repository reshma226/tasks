package com.mypack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	UserRepos r;
	@Autowired
	ProductRepos pr;
	@Autowired
	RequestRepos rr;
	
	@RequestMapping("/users")
	public String userList(Model m)
	{
		
		var users=(List<Users>)r.findAll();
		m.addAttribute("users",users);
		return "listUsers.jsp";
		
	}
	
	
	
	@RequestMapping("/inventory")
	public String productList(Model m)
	{
		
		var products=(List<Products>)pr.findAll();
		m.addAttribute("products",products);
		return "productlist.jsp";
	}
	
	@RequestMapping("/requests")
	public String requestList(Model m)
	{
		
		var requests=(List<Requests>)rr.findAll();
		m.addAttribute("requests",requests);
		return "requestlist.jsp";
	}
	
}
