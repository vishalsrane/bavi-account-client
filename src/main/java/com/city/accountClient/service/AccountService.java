package com.city.accountClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.city.accountClient.dto.AccountInfoDtoFromServer;
import com.city.accountClient.model.Account;
import com.city.accountClient.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private AccountRepository accountRepository;

	public AccountInfoDtoFromServer getAccountDetails() {
		RestTemplate restTemplate = restTemplateBuilder.basicAuthorization("admin","pass").build();
		AccountInfoDtoFromServer dto = restTemplate.getForObject("http://localhost:9001/account/accountInfo/", 
				AccountInfoDtoFromServer.class);
		Account account = new Account();
		account.setContact(dto.getContact());
		account.setName(dto.getName());
		accountRepository.save(account);
		return dto;
	}

}
