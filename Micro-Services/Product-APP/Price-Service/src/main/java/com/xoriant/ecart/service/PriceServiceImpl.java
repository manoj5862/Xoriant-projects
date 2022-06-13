package com.xoriant.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.PriceDao;
@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	private PriceDao priceDao;
	
	@Override
	public double getItemPrice(int productId) {
		// TODO Auto-generated method stub
		return priceDao.getItemPrice(productId);
	}

}
