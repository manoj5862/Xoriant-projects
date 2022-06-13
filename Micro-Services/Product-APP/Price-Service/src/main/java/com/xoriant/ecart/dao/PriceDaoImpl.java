package com.xoriant.ecart.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.dao.utils.DBQueries;

@Repository
public class PriceDaoImpl implements PriceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getItemPrice(int productId) {
		Map<String, Object> data = jdbcTemplate.queryForMap(DBQueries.FIND_PRICE, productId);
		int price = (int) data.get("product_price");
		return price;

	}

}
