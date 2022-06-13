package com.xoriant.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductService;

@Controller
public class EcartController {
	
	@Autowired
	private ProductService ps;
	
	
	// load welcome page
	
	@GetMapping
	public String welcome() {
		return "index";
	}
	
	// load form
	@RequestMapping("/loadForm")
	public String loadProductFrom() {
		return "product-form";
	}
	
	@RequestMapping("/findAll")
	public String findAllProducts(ModelMap model) {
		
		List<Product> products = ps.findAllProductsV2();
		
		model.addAttribute("prods", products);
		
		
		return "products";
	}
	
	
	
	
	@RequestMapping(value = "/s1")
	public void f1() {
		System.out.println(">>> EcartController:: f1 method");
	}
	
	
	@RequestMapping(value = "/s2")
	public String f2() {
		System.out.println(">>> EcartController:: f2 method");
		return "sample";
	}
	
	@RequestMapping(value = "/s3")
	public String f3(Model model) {
		System.out.println(">>> EcartController:: f3 method");
		
		model.addAttribute("user", "Praveen");
		model.addAttribute("city", "Hyderabad");
	
		return "info";
	}

	
	@RequestMapping(value = "/s4")
	public ModelAndView f4() {
		System.out.println(">>> EcartController:: f3 method");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("info");
	
		mav.addObject("user", "Ozvitha");
		mav.addObject("city", "Goa");
	
		return mav;
	}


}
