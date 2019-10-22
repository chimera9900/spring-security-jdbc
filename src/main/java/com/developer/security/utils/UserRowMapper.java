package com.developer.security.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.developer.security.model.CustomUser;

public class UserRowMapper implements RowMapper<CustomUser> {
	
	@Override
	public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomUser user = new CustomUser();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		return user;
	}

}
