package com.city.accountClient.repository;

import org.springframework.data.repository.CrudRepository;

import com.city.accountClient.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{

}
