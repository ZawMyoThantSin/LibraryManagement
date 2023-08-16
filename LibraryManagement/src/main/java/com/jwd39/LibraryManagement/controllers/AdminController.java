package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.AccountDAO;
import com.jwd39.LibraryManagement.models.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class AdminController {
    @GetMapping("/admin/home")
    public String adminHome(Model model) throws SQLException {
        List<Account> user = new AccountDAO().allACData();
        model.addAttribute("users",user );

        return"admin/admin.home";
    }
    @GetMapping("/book/create")
    public String createBook(){
        return "admin/createBook";

    }

}
