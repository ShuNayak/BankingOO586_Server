package com.api.comp586.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.comp586.dao.SavingsDAO;
import com.api.comp586.dao.UsersDAO;
import com.api.comp586.entity.Savings;
import com.api.comp586.entity.Users;
import com.api.comp586.sevice.SavingsService;

@Service
public class SavingsServiceImpl implements SavingsService {

	@Autowired
	SavingsDAO savingsDao;
	
	@Override
	public Savings queryBalance(String accountId) {
		// TODO Auto-generated method stub
		return savingsDao.getOne(accountId);
	}

	@Override
	public Savings sendMoney(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
