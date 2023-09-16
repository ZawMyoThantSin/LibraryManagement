package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.AccountDao;
import com.jwd39.LibraryManagement.helpers.SHA_256Helper;
import com.jwd39.LibraryManagement.impls.AccountDaoImpl;
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

    public Account findById(int id){
        return accountDao.findById(id);
    }

    public int delete(int id){
        return accountDao.delete(id);
    }

    public Account validate(String email,String password){
        return accountDao.validate(email,password);
    }

    public boolean emailConfirm(String email){
        boolean status = false;
        List<Account> users = getAll();
        for (Account user : users){
            if(user.getEmail().equalsIgnoreCase(email)){
                status = true;
            }
        }

        return status;
    }

}
