package com.developer.security.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.developer.security.model.Role;

public class RoleRowMapper implements RowMapper<Role> {
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setRole(rs.getString("role"));
		role.setEmail(rs.getString("email"));
		return role;
	}

}
