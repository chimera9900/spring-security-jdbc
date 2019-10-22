package com.developer.security.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.developer.security.model.CustomUser;
import com.developer.security.model.Role;
import com.developer.security.utils.RoleRowMapper;
import com.developer.security.utils.UserRowMapper;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	NamedParameterJdbcTemplate jdbc;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String sql = "select * from user u where u.email = :email";
		CustomUser user = jdbc.queryForObject(sql, new MapSqlParameterSource("email", username), new UserRowMapper());
		String sql1="select * from roles r where r.email = :email";
		
		List<Role> list = jdbc.query(sql1, 
				new MapSqlParameterSource("email", username), 
				new RoleRowMapper() );
		Collection<GrantedAuthority> auth = list.stream()
		.map(x -> new SimpleGrantedAuthority(x.getRole()))
		.collect(Collectors.toList());
		return (UserDetails) new User(user.getEmail(),user.getPassword(), auth );

	}

}
