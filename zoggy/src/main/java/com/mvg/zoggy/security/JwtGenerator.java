package com.mvg.zoggy.security;

import java.util.UUID;

public class JwtGenerator {
	public  String generateToken() {
		 String uuid = UUID.randomUUID().toString().replace("-", ""); // 32 characters
	     String additionalRandom = UUID.randomUUID().toString().replace("-", "").substring(0, 18); // 18 more characters
	     String customUuid = uuid + additionalRandom; // 50 characters
	     System.out.println("Custom 50-char UUID: " + customUuid);
	     return customUuid;
	     
    }
}
