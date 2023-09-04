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
        //String hashed = SHA_256Helper.encrypt(account.getPassword());
        //account.setPassword(hashed);
        return accountDao.save(account);
    }

    public List<Account> getAll(){
        AccountDao dao = new AccountDaoImpl();
        return dao.getAll();
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
        AccountDao dao = new AccountDaoImpl();
        return dao.validate(username,password);
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