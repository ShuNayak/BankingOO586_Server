package com.api.comp586.sevice;

import java.util.List;

import com.api.comp586.entity.Users;

public interface UsersService {

	Users registerUser(Users user);
	Users updateUserDetails(Users user);
	Users displayUserdetails(Integer userId);
	List<Users> displayAllUsers();
}
