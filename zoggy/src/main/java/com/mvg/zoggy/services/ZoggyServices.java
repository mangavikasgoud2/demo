package com.mvg.zoggy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mvg.zoggy.common.CommonConstants;
import com.mvg.zoggy.controller.CoreData;
import com.mvg.zoggy.controller.ZoggyController;
import com.mvg.zoggy.model.LoginDTO;
import com.mvg.zoggy.repository.ZoggyRepository;
import com.mvg.zoggy.security.JwtGenerator;

@Service
public class ZoggyServices {
	
	@Autowired
	private ZoggyRepository zoggyRepository;
	
	JwtGenerator jwtGenerator = new JwtGenerator();
	
	private static final Logger logger = LoggerFactory.getLogger(ZoggyController.class);

	public CoreData getUsers(CoreData coreData) {
		// TODO Auto-generated method stub
		logger.info("coreData getUser "+new Gson().toJson(coreData));
		String zoggyUser = zoggyRepository.getUserDetails(coreData);
		logger.info("coreData zoggyUserJWT  "+new Gson().toJson(zoggyUser));
		coreData.getLoginDTO().setJwt(zoggyUser);
		if(zoggyUser.length() > 0) {
			//coreData.setLoginSuccess(true);
			coreData.setStatus(CommonConstants.SUCCESS);
			coreData.setStatusDesc(CommonConstants.LOGINSUCCESS);
		}else {
			//coreData.setLoginSuccess(false);
			coreData.setStatus(CommonConstants.FAILURE);
			coreData.setStatusDesc(CommonConstants.LOGINUNSUCCESS);
		}
		
		logger.info("zoggyUser "+new Gson().toJson(coreData));
		return coreData;
	}
	
	public CoreData addUsers(CoreData coreData) {
		
		coreData = getUsers(coreData);
		logger.info("core adduser 42 "+new Gson().toJson(coreData));
		if(coreData.getStatus().equals(CommonConstants.SUCCESS) ) {
			coreData.setStatus(CommonConstants.FAILURE);
			coreData.setStatusDesc(CommonConstants.EXISTINGUSER);
		}else {
			String jwt = jwtGenerator.generateToken();
			int zoggyUser = zoggyRepository.addUserDetails(coreData, jwt);
			if(zoggyUser > 0) {
				//coreData.setLoginSuccess(true);
				coreData.setStatus(CommonConstants.SUCCESS);
				coreData.setStatusDesc(CommonConstants.SIGNINSUCCESS);
			}else {
				//coreData.setLoginSuccess(false);
				coreData.setStatus(CommonConstants.FAILURE);
				coreData.setStatusDesc(CommonConstants.SIGNINUNSUCCESS);
			}
			
			logger.info("zoggyUser "+zoggyUser);
		}
		
		logger.info("core adduser 61 "+new Gson().toJson(coreData));
		return coreData;
	}

	
   
}
