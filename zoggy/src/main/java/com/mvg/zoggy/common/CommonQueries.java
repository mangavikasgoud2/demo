package com.mvg.zoggy.common;


public class CommonQueries {
	public static String GETUSERDETAILS = "SELECT jwt FROM zoggyusers WHERE (USERNAME = ? OR EMAIL = ?) AND PASSWORD = ?";
	public static String ADDUSERDETAILS = "INSERT INTO zoggyusers (username, password, phnumber, email, jwt) VALUES (?,?,?,?,?)";
}
