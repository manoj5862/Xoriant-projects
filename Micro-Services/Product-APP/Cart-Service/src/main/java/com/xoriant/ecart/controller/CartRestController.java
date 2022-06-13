package com.xoriant.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.ItemLine;
import com.xoriant.ecart.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartRestController {

	@Autowired
	private CartService cartService;

	// save Item to the cart
	@GetMapping("/{productId}/{user}/{qty}")
	public ItemLine addItemToCart(@PathVariable int productId, @PathVariable String user, @PathVariable int qty) {
		ItemLine itemLine = cartService.save(user, qty, productId);
		return itemLine;

	}
	
	// get all items in a cart of a user
	@GetMapping("/{user}")
	public List<ItemLine> cartItems(@PathVariable String user){
		return cartService.findAll(user);
	}
	
	@DeleteMapping("/{user}")
	public void clearCart(@PathVariable String user) {
		cartService.clearCart(user);
	}

}
