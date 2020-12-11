package com.mypack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mypack.models.Products;
import com.mypack.models.Requests;
import com.mypack.models.Users;
import com.mypack.repository.ProductRepos;
import com.mypack.repository.RequestRepos;
import com.mypack.repository.UserRepos;

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
		
		if((MainController.getUname()).equals("admin")) 
		{
			System.out.println(MainController.getUname());
		var users=(List<Users>)r.findAll();
		m.addAttribute("users",users);
		return "listUsers.jsp";
		}
		else {
			m.addAttribute("error","You have to login first...");
			return "Login.jsp";
		}
	}
	
	@RequestMapping("/delete")
	public String deleteUser(Model m,@RequestParam("id")long id)
	{
			
		r.deleteById(id);
		return userList(m);
	}
	
	@RequestMapping("/inventory")
	public String productList(Model m)
	{
		if(MainController.getUname().equals("admin")) 
		{
		var products=(List<Products>)pr.findAll();
		m.addAttribute("products",products);
		return "productlist.jsp";
		}
		else {
			m.addAttribute("error","You have to login first...");
			return "Login.jsp";
		}
		
	}
	
	@RequestMapping("/requests")
	public String requestList(Model m)
	{
		if(MainController.getUname().equals("admin")) 
		{
		var requests=(List<Requests>)rr.findAll();
		m.addAttribute("requests",requests);
		return "requestlist.jsp";
		}
		else {
			m.addAttribute("error","You have to login first...");
			return "Login.jsp";
		}
		
	}
	@RequestMapping("/approve/d+$")
	public String approveRequest(Model m,@RequestParam("id")int id)
	{
		
			Requests r1=rr.findById(id);
			int q=r1.getQuantity();
			Products p=pr.findById(r1.getPid());
			int i=p.getQuantity();
			i=i+(2*q);
			pr.updateQuantity(p.getId(), i);
			rr.deleteById(id);
			 return requestList(m);
	}
	@DeleteMapping("/delete/d+$")
	public String deleteRequest(Model m,@RequestParam("id")int id) {
		rr.deleteById(id);
		 return requestList(m);
	}
	
}
