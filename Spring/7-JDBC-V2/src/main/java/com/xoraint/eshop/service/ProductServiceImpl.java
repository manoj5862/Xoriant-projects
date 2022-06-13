package com.xoraint.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.xoraint.eshop.dao.ProductDao;
import com.xoraint.eshop.model.Brand;
import com.xoraint.eshop.model.Cart;
import com.xoraint.eshop.model.Category;
import com.xoraint.eshop.model.Product;
import com.xoraint.eshop.model.User;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Brand addNewBrand(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category addNewCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public Cart addItemToCart(Product product, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCartItem(int cartId, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCartItems(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkOut(String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> listCartItems(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placeNewOrder(Cart cart, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listAllOrders(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancelOrder(int orderId, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateUser(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProductsV2() {
		// TODO Auto-generated method stub
		return productDao.findAllProductsV2();
	}

	@Override
	public List<Product> findAllProductsV3() {
		// TODO Auto-generated method stub
		return productDao.findAllProductsV3();
	}

	@Override
	public Product findProductById(int prodId) {
		// TODO Auto-generated method stub
		return productDao.findProductById(prodId);
	}

	@Override
	public List<Product> findProductByName(String productName) {
		// TODO Auto-generated method stub
		return productDao.findProductByName(productName);
	}
	
	
	
	

}
