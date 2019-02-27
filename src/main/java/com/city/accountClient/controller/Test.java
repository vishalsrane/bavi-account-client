package com.city.accountClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.city.accountClient.dto.AccountInfoDtoFromServer;
import com.city.accountClient.service.AccountService;

@RestController
public class Test {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/test")
	public AccountInfoDtoFromServer test() {
		AccountInfoDtoFromServer accountInfoDtoFromServer = accountService.getAccountDetails();
		return accountInfoDtoFromServer;
	}

}
