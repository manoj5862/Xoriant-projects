package com.xoraint.eshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.xoraint.eshop.model.Product;

@Repository
public class ProductDaoImpl {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// find all Products using queryForList
	public List<Map<String, Object>> findAll() {
		return jdbcTemplate.queryForList("select * from products");

	}

	/*
	 * using Domain Objects
	 *  ========================== 
	 * 1. RowMapper 
	 * 	-> T mapRow(ResultSet rs, int rowNum) 
	 * 2. RowCallbackHandler 
	 * 	-> void processRow(ResultSet rs) throws SQLException
	 * 3. ResultSetExtractor
	 *  -> T extractData(ResultSet rs)
	 */

	// any JDBC DML operations

	// 1 . save new product

	public Product save(Product product) {

		String qry = "insert into products values(?,?,?,?,?,?,?,?,?)";

		int res = jdbcTemplate.update(qry, product.getProductId(), product.getCategory().getCategoryId(),
				product.getBrand().getBrandId(), product.getProductName(), product.getPrice(), product.getQuantity(),
				product.getDescription(), product.getImagePath(), product.getKeywords());

		if (res != 0) {
			return product;
		}

		return null;

	}

	// 1. RowMapper
	// ==================

	public List<Product> getAllProducts() {
		List<Product> prods = jdbcTemplate.query("select * from products", new RowMapperTest());
		return prods;
	}

	// 3. ResultSetExtractor
	// ==========================

	public List<Product> getAllProductsV1() {
		List<Product> prods = jdbcTemplate.query("select * from products", new ResultSetExtractorTest());

		return prods;
	}

	// using lamda expression
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<Product> findAllProductsV2() {
		return jdbcTemplate.query("select * from products", (ResultSet rs) -> {
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

	// using lamda expression
	public Product findProductById(int prodId) {
		return jdbcTemplate.query("select * from products where product_id=?", (ResultSet rs) -> {

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

	// using lamda expression
	public List<Product> findProductByName(String productName) {
		return jdbcTemplate.query("select * from products where product_title like ?", (ResultSet rs) -> {

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
}

class ResultSetExtractorTest implements ResultSetExtractor<List<Product>> {

	List<Product> prods = new ArrayList<Product>();

	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {

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
	}
}

class RowMapperTest implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product prod = null;
		
		prod = new Product();
		prod.setProductId(rs.getInt("product_id"));
		prod.setProductName(rs.getString("product_title"));
		prod.setDescription(rs.getString("product_desc"));
		prod.setImagePath(rs.getString("product_image"));
		prod.setKeywords(rs.getString("product_keywords"));
		prod.setPrice(rs.getDouble("product_price"));
		prod.setQuantity(rs.getInt("product_qty"));

		return prod;
	}
}
