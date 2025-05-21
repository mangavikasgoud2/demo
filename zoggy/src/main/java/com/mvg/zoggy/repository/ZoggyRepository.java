package com.mvg.zoggy.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvg.zoggy.common.*;
import com.mvg.zoggy.controller.CoreData;
import com.mvg.zoggy.controller.ZoggyController;
import com.mvg.zoggy.model.LoginDTO;

@Repository
public class ZoggyRepository {
	private static final Logger logger = LoggerFactory.getLogger(ZoggyRepository.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public String getUserDetails(CoreData coreData) {
		String zoggyUserJwt = "";
		try {
			zoggyUserJwt = jdbcTemplate.queryForObject(CommonQueries.GETUSERDETAILS, String.class ,coreData.getLoginDTO().getUsername(),coreData.getLoginDTO().getUsername(), coreData.getLoginDTO().getPassword());
			logger.info("zoggyUserJwt 25 repo "+zoggyUserJwt);
		}catch(Exception e) {
			logger.info("Exception e "+e);
		}
		return zoggyUserJwt;
	}
	
	public int addUserDetails(CoreData coreData, String jwt) {
		int zoggyadd = 0;
		try {
			zoggyadd = jdbcTemplate.update(CommonQueries.ADDUSERDETAILS,coreData.getLoginDTO().getUsername(), coreData.getLoginDTO().getPassword(), coreData.getLoginDTO().getPhnumber(), coreData.getLoginDTO().getEmail(), jwt);
			logger.info("zoggy Repo 35 "+zoggyadd);
		}catch(Exception e) {
			logger.info("Exception e "+e);
		}
		return zoggyadd;
	}
}
