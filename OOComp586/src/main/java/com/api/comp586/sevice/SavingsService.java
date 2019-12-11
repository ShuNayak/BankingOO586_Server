package com.api.comp586.sevice;

import com.api.comp586.entity.Savings;
import com.api.comp586.entity.Users;

public interface SavingsService {

	Savings queryBalance(String userId);
	Savings sendMoney(Users user);
}
