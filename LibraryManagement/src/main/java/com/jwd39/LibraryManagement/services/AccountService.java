package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.AccountDao;
import com.jwd39.LibraryManagement.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public int save(Account account){
        return accountDao.save(account);
    }

    public List<Account> getAll(){
        return accountDao.getAll();
    }

    public int update(Account account){
        return accountDao.update(account);
    }

    public Account getById(int id){
        return accountDao.getById(id);
    }

    public int delete(int id){
        return accountDao.delete(id);
    }

    public Account validate(String username,String password){
        return accountDao.validate(username,password);
    }


}
