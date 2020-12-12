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
	@RequestMapping("/add_deletecart")
	public String decision(@RequestParam("qty")int q,@RequestParam("pid")int pid,@RequestParam("decision")String decision,Model m)
	{ 
		if(decision.equals("Add to Cart"))
		return addToCart(q, pid, m);
		else 
		return notifyAdmin(q, pid, m);
		
	}
	@GetMapping("/addproduct")
	public String addToCart(int q,int pid,Model m)
	{
		int id=(int)cr.count();
		id=id+1;
		Products p=pr.findById(pid);
		int i=p.getQuantity();
		if(i>q) {
		i=i-q;
		p.setQuantity(i);
		pr.save(p);
		Cart uc=new Cart(id,MainController.getUname(),pid,p.getName(),q,p.getPrice());
		cr.save(uc);
		m.addAttribute("msg","Successfully added to cart");
		}
		else
			m.addAttribute("msg","!!!Product quantity is not available,please click notify to place request..!!!");
		return productList(m);
	
	}
	@RequestMapping("/notify")
	public String notifyAdmin(int q,int pid,Model m)
	{
		int id=(int)rr.count();
		id=id+1;
		Products p=pr.findById(pid);
		//System.out.println(id);
		Requests r1=new Requests(id,MainController.getUname(),pid,p.getName(),q);
		System.out.println(r1);
		rr.save(r1);
		m.addAttribute("msg","Notified to admin. will update soon....");
		return productList(m);
	
	}
	@RequestMapping("/cart")
	public String cartList(Model m)
	{
		List<Cart> cart=cr.findByuname(MainController.getUname());
		m.addAttribute("cart",cart);
		return "cart.jsp";
		
	}
	@RequestMapping("/cart_delete")
	public String deleteCart(Model m,@RequestParam("id")int id)
	{
		
		Cart c=cr.findById(id);
		Products p=pr.findById(c.getPid());
		p.setQuantity(p.getQuantity()+c.getQuantity());
		pr.save(p);
		cr.deleteById(id);
		return cartList(m);
	}

	@RequestMapping("/cart_order")
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
	@RequestMapping("/logout")
	public String logout()
	{
		MainController.setUname(null);
		return "Login.jsp";
	}
}
