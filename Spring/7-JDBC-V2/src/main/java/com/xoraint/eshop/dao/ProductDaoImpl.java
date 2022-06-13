package com.xoraint.eshop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.xoraint.eshop.dao.utils.DBQueries;
import com.xoraint.eshop.model.Brand;
import com.xoraint.eshop.model.Cart;
import com.xoraint.eshop.model.Category;
import com.xoraint.eshop.model.Product;
import com.xoraint.eshop.model.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// DML operations using method
	@Override
	public Brand addNewBrand(Brand brand) {
		return null;
	}
	
	@Override
	public Category addNewCategory(Category category) {
		return null;
	}

	// 1.save new product
	@Override
	public Product save(Product product) {

		int res = jdbcTemplate.update(DBQueries.PRODUCT_SAVE, product.getProductId(), product.getCategory().getCategoryId(),
				product.getBrand().getBrandId(), product.getProductName(), product.getPrice(), product.getQuantity(),
				product.getDescription(), product.getImagePath(), product.getKeywords());

		if (res != 0) {
			return product;
		}

		return null;

	}
	
	// Cart operations
	
	// 1. Add Item to cart?
	 @Override
	public Cart addItemToCart(Product product,String user) {
		 return null;
	 }
	 
	 // 2. Delete item from cart
	 @Override
	public void deleteCartItem(int cartId,String user) {
		 
	 }
	 
	 // 3. clear cart items
	 @Override
	public void clearCartItems(String user) {
		 
	 }
	 
	 // 4.check out
	 @Override
	public boolean checkOut(String user) {
		 return false;
	 }
	 
	 //5.list all cart items
	 @Override
	public List<Cart> listCartItems(String user){
		 return null;
	 }
	 
	 
	 // order operations
	 // 1. Place new order
	 @Override
	public Order placeNewOrder(Cart cart,String user) {
		 return null;
	 }
	 
	 //2. list all orders of a user
	 @Override
	public List<Order> listAllOrders(String user){
		 return null;
	 }
	 
	 //3. cancel order
	 @Override
	public Order cancelOrder(int orderId,String user) {
		return null; 
	 }
	 
	 
	 
	 //login/user operations
	 
	 // 1. validate user
	 @Override
	public boolean validateUser(String user,String password) {
		 return false;
	 }
	 
	 // 2. add new user
	 @Override
	public User addNewUser(User user) {
		 return null;
	 }
	 
	 
	// using lambda expression
	@Override
	public List<Product> findAllProductsV2() {
		return jdbcTemplate.query(DBQueries.LIST_ALL_PRODUCTS, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductId(rs.getInt("product_id"));
				prod.setProductName(rs.getString("product_title"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setImagePath(rs.getString("product_image"));
				prod.setKeywords(rs.getString("product_keywords"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("product_qty"));
				prods.add(prod);
			}
			return prods;
		});
	}

	// fetch all products
	@Override
	public List<Product> findAllProductsV3(){
		//var rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
		return jdbcTemplate.query("select * from products", new BeanPropertyRowMapper<Product>(Product.class));
	}


	// using lambda expression
	@Override
	public Product findProductById(int prodId) {
		return jdbcTemplate.query(DBQueries.FIND_PRODUCT_BY_ID, (ResultSet rs) -> {

			Product prod = null;
			if (rs.next()) {
				prod = new Product();
				prod.setProductId(rs.getInt("product_id"));
				prod.setProductName(rs.getString("product_title"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setImagePath(rs.getString("product_image"));
				prod.setKeywords(rs.getString("product_keywords"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("product_qty"));

			}
			return prod;
		}, prodId);
	}

	// using lambda expression
	@Override
	public List<Product> findProductByName(String productName) {
		return jdbcTemplate.query(DBQueries.FIND_PRODUCTS_By_NAME, (ResultSet rs) -> {

			Product prod = null;
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				prod = new Product();
				prod.setProductId(rs.getInt("product_id"));
				prod.setProductName(rs.getString("product_title"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setImagePath(rs.getString("product_image"));
				prod.setKeywords(rs.getString("product_keywords"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("product_qty"));
				prods.add(prod);

			}
			return prods;
		}, productName);
	}
} // END OF ProductDaoImpl CLASS

