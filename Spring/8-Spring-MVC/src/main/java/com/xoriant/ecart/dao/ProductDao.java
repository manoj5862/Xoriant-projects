package com.xoriant.ecart.dao;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Cart;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.model.User;

public interface ProductDao {

	// DML operations using method
	Brand addNewBrand(Brand brand);

	Category addNewCategory(Category category);

	// 1.save new product
	Product save(Product product);

	// 1. Add Item to cart?
	Cart addItemToCart(Product product, String user);

	// 2. Delete item from cart
	void deleteCartItem(int cartId, String user);

	// 3. clear cart items
	void clearCartItems(String user);

	// 4.check out
	boolean checkOut(String user);

	//5.list all cart items
	List<Cart> listCartItems(String user);

	// order operations
	// 1. Place new order
	Order placeNewOrder(Cart cart, String user);

	//2. list all orders of a user
	List<Order> listAllOrders(String user);

	//3. cancel order
	Order cancelOrder(int orderId, String user);

	// 1. validate user
	boolean validateUser(String user, String password);

	// 2. add new user
	User addNewUser(User user);

	// using lambda expression
	List<Product> findAllProductsV2();

	// fetch all products
	List<Product> findAllProductsV3();

	// using lambda expression
	Product findProductById(int prodId);

	// using lambda expression
	List<Product> findProductByName(String productName);

}