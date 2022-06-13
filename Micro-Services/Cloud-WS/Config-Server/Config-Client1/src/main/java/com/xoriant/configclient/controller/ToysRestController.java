package com.xoriant.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/toys")
@CrossOrigin
@RefreshScope
public class ToysRestController {
	
	@Value("${toyname}")
	private String toyName;
	
	@GetMapping
	public String getToyName() {
		return "Toy name is "+toyName;
	}

}
