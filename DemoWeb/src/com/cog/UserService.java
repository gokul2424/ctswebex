package com.cog;

import com.cog.model.User;

public class UserService {
	
	public boolean authenticate(User user){
		System.out.println(user.getEmail());
		System.out.println(user.getPwd());
		return user.getEmail().equals(user.getPwd());
	}

}
