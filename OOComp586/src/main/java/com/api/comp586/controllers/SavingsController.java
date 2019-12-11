package com.api.comp586.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.comp586.entity.Savings;
import com.api.comp586.sevice.SavingsService;

@RequestMapping("Savings")
@RestController
public class SavingsController {

	@Autowired
	SavingsService savingsService;

	@GetMapping("/display/{accountId}")
	public ResponseEntity<Savings> displayUserBalance(@PathVariable(name = "accountId") String accountId) {
		return new ResponseEntity<Savings>(savingsService.queryBalance(accountId), HttpStatus.OK);
	}

}
