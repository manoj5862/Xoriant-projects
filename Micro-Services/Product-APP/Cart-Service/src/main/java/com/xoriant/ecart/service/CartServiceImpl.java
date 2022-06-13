package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.dao.CartDao;
import com.xoriant.ecart.model.Item;
import com.xoriant.ecart.model.ItemLine;
import com.xoriant.ecart.model.Product;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	private RestTemplate rt = new RestTemplate();

	@Override
	public ItemLine save(String user, int qty, int productId) {
		Product product = rt.getForObject("http://localhost:8081/api/products/" + productId, Product.class);

		Item item = null;
		if (product == null) {
			return null;
		}
		item = new Item(productId, product.getProductName(), product.getPrice());

		ItemLine itemLine = new ItemLine(item, qty);
		itemLine.setTotalPrice(qty*product.getPrice());

		return cartDao.save(user, itemLine);
	}

	@Override
	public List<ItemLine> findAll(String user) {
		
		List<ItemLine> cartItems = cartDao.findAll(user);
		
		double totalPrice = cartItems.stream().mapToDouble(il->il.getQty()*il.getItem().getPrice()).sum();
		
		System.out.println(">>>> Total Cost:::: "+totalPrice);
		
		return cartItems;
	}

	@Override
	public void clearCart(String user) {
		cartDao.clearCart(user);
	}

}
