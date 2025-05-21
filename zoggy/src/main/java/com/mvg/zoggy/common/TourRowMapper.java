package com.mvg.zoggy.common;

import org.springframework.jdbc.core.RowMapper;

import com.mvg.zoggy.model.LoginDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourRowMapper implements RowMapper<LoginDTO>  {

	@Override
    public LoginDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LoginDTO(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getLong("phnumber"),
                rs.getString("email"),
                rs.getString("jwt")
        );
    }
	
}
