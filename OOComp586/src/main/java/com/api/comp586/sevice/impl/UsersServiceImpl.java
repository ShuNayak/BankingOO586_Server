package com.api.comp586.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.comp586.dao.UsersDAO;
import com.api.comp586.entity.Users;
import com.api.comp586.sevice.UsersService;


@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAO usersDao;
	
	@Override
	public Users registerUser(Users user) {
		// TODO Auto-generated method stub
		return usersDao.save(user);
		
	}

	@Override
	public Users updateUserDetails(Users user) {
		// TODO Auto-generated method stub
		return usersDao.saveAndFlush(user);
	}

	@Override
	public Users displayUserdetails(Integer userId) {
		// TODO Auto-generated method stub
		return usersDao.getOne(userId);
	}

	@Override
	public java.util.List<Users> displayAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.findAll();
	}

	

}
