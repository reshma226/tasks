package com.mypack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {
	
	@Autowired
	ProductRepos pr;
	@RequestMapping("/products")
	public String productList(Model m)
	{
		
		var products=(List<Products>)pr.findAll();
		m.addAttribute("products",products);
		return "productlist.jsp";
	}
	

}
