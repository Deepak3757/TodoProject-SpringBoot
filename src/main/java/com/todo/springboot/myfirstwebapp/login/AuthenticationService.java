package com.todo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String pass) {
		boolean nameMatch=username.equalsIgnoreCase("deepak");
		boolean passMatch=pass.equals("Deep1234");
		return nameMatch&&passMatch;
		
	}
}
