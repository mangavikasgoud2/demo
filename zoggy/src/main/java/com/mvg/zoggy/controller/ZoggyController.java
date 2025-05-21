package com.mvg.zoggy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.gson.Gson;
import com.mvg.zoggy.model.LoginDTO;
import com.mvg.zoggy.services.*;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:4200, http://localhost:8080")
public class ZoggyController {
	
	@Autowired
	ZoggyServices tourismServices;
	
	private static final Logger logger = LoggerFactory.getLogger(ZoggyController.class);

	@PostMapping("/login")
	public ResponseEntity<CoreData> getLoginCredentials(@RequestBody CoreData request) {
		logger.info("request: {}", new Gson().toJson(request));
		//CoreData coreData = new CoreData();
		HashMap<String, String> response = new HashMap<>();
	    response.put("message", "HelloWorld");
	    CoreData coreDto = tourismServices.getUsers(request);
	    logger.info("tourismServices.getUsers() "+new Gson().toJson(coreDto));
	    return ResponseEntity.ok(coreDto);
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<CoreData> addSignUpCredentials(@RequestBody CoreData request) {
		logger.info("SignUP request: {}", new Gson().toJson(request));
		//CoreData coreData = new CoreData();
		HashMap<String, String> response = new HashMap<>();
	    response.put("message", "HelloWorld");
	    CoreData coreDto = tourismServices.addUsers(request);
	    logger.info("tourismServices.getUsers() "+new Gson().toJson(coreDto));
	    return ResponseEntity.ok(coreDto);
	}
}
