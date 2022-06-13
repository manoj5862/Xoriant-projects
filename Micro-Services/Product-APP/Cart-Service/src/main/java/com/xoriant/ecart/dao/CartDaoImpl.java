package com.xoriant.ecart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.ItemLine;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private RedisTemplate<String, ItemLine> template;
	
	@Resource(name="redisTemplate")
	private ListOperations<String, ItemLine> listOps;
	
	//save cart Item to the cart
	@Override
	public ItemLine save(String user,ItemLine itemLine) {
		System.out.println(">>> user:: "+user);
		listOps.leftPush(user, itemLine);
		System.out.println(">>>>>> CARTDAO:: "+itemLine+" saved to Redis DB");
		return itemLine;
	}
	
	// load all cart items
	@Override
	public List<ItemLine> findAll(String user){
		return listOps.range(user, 0, -1);
	}
	
	// clear cart for a user
	@Override
	public void clearCart(String user) {
		template.delete(user);
	}
	
	
	
	
	
	

}
