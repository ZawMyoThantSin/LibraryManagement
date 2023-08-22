package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Account;

import java.util.List;

public interface AccountDao {

    int save(Account account);

    List<Account> getAll();

    int update(Account account);

    Account getById(int id);

    Account validate (String username, String password);
}
