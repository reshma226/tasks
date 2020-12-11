package com.mypack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mypack.models.Cart;
import com.mypack.models.Products;
import com.mypack.models.Requests;
import com.mypack.repository.CartRepos;
import com.mypack.repository.ProductRepos;
import com.mypack.repository.RequestRepos;
import com.mypack.repository.UserRepos;

@Controller
public class UserController {
	
	@Autowired
	ProductRepos pr;
	
	@Autowired
	UserRepos ur;
	
	@Autowired
	CartRepos cr;
	
	@Autowired
	RequestRepos rr;
	
	String name=MainController.getUname();
	
	@RequestMapping("/products")
	public String productList(Model m)
	{
		
		//if(name!=null)
		//{
		var products=(List<Products>)pr.findAll();
		m.addAttribute("products",products);
		return "products.jsp";
		/*}
		else {
			m.addAttribute("error","You have to login first...");
		return "Login.jsp";*/
	
	}
	@GetMapping("/addproduct")
	public void addToCart(@RequestParam("qty")int q,@RequestParam("pid")int pid,Model m)
	{
		int id=(int)cr.count();
		id=id+1;
		System.out.println(pid);
		Products p=pr.findById(pid);
		int i=p.getQuantity();
		i=i-q;
		pr.updateQuantity(pid, i);
		pr.save(p);
		String pname=p.getName();
		System.out.println(MainController.getUname());
		Cart uc=new Cart(id,MainController.getUname(),pid,pname,q);
		cr.save(uc);
		
	
	}
	@RequestMapping("/notify")
	public void notifyAdmin(@RequestParam("qty")int q,@RequestParam("pid")int pid)
	{
		int id=(int)rr.count();
		id=id+1;
		Products p=pr.findById(pid);
		String pname=p.getName();
		Requests r=new Requests(id,name,pid,pname,q);
		rr.save(r);
	}
	@RequestMapping("/cart")
	public String cartList(Model m)
	{
		
		
		List<Cart> cart=cr.findByuname(name);
		m.addAttribute("cart",cart);
		return "cart.jsp";
		
	}
	@RequestMapping("/cart/delete")
	public void deleteCart(Model m,@RequestParam("id")int id)
	{
		
		Cart c=cr.findById(id);
		pr.updateQuantity(c.getPid(), c.getQuantity());
		cr.deleteById(id);
		cartList(m);
	}

	@RequestMapping("/cart/order")
	public void order(Model m)
	{
		List<Cart> cart=cr.findByuname(name);
		List<Products> product=pr.findAll();
		float i=0;
		for(Products p:product) {
			for(Cart c:cart) {
				if(p.getId()==c.getId())
					i=(i+(c.getQuantity()*p.getPrice()));
			}
		}
		cartList(m);
		m.addAttribute("i",i);
	}
}
