package com.xoriant.ecart.service;

import java.util.List;

import com.xoriant.ecart.model.ItemLine;

public interface CartService {

	// save cart Item to the cart
	ItemLine save(String user, int qty, int productId);

	// load all cart items
	List<ItemLine> findAll(String user);

	// clear cart for a user
	void clearCart(String user);

}
