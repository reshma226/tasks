package com.mypack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.models.Cart;
import com.mypack.models.Item;
import com.mypack.models.Products;
import com.mypack.models.Request;
import com.mypack.models.Requests;
import com.mypack.repository.CartRepos;
import com.mypack.repository.ProductRepos;
import com.mypack.repository.RequestRepos;
import com.mypack.repository.UserRepos;

@RestController
public class UserController {
	
	@Autowired
	ProductRepos pr;
	
	@Autowired
	UserRepos ur;
	
	@Autowired
	CartRepos cr;
	
	@Autowired
	RequestRepos rr;
	
		
	@PostMapping("/cart/addItem")
	ResponseEntity<?> addToCart(@RequestBody Item item)
	{
		Products p=pr.findById(item.getProductID());
		p.setQuantity(p.getQuantity()-item.getProductQuantity());
		pr.save(p);
				
		for(Cart c:cr.findBypid(item.getProductID()))
		{
		if(c.getUname().equals(item.getUserName()))
		{
			Cart cart=cr.findById(c.getId());
			cart.setQuantity(c.getQuantity()+item.getProductQuantity());
			cr.save(cart);
		}
		else {
			Cart uc=new Cart();
			uc.setPid(item.getProductID());
			uc.setPname(item.getProductName());
			uc.setPrice(item.getProductPrice());
			uc.setQuantity(item.getProductQuantity());
			uc.setUname(item.getUserName());
			cr.save(uc);
		}
		
		}
		return ResponseEntity.ok().build();
		

	}
	@PostMapping("/requests/addRequest")
	public ResponseEntity<Requests> notifyAdmin(@RequestBody Request request)
	{
		Requests r1=new Requests();
		r1.setPid(request.getProductID());
		r1.setPname(request.getProductName());
		r1.setUname(request.getUserName());
		r1.setQuantity(request.getProductQuantity());
		rr.save(r1);
		return ResponseEntity.ok().build();

	}
	@GetMapping("/cart")
	public List<Cart> getUserCart(){
		return this.cr.findAll();
	}
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable("id")int id)
	{
		Cart c=cr.findById(id);
		Products p=pr.findById(c.getPid());
		p.setQuantity(p.getQuantity()+c.getQuantity());
		pr.save(p);
		cr.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/cart")
	public ResponseEntity<?> order(@RequestBody String username)
	{
		for(Cart c:cr.findByuname(username)) {
			Cart c1=cr.findById(c.getId());
			cr.delete(c1);
		}
		return ResponseEntity.ok().build();
	}
	
}
