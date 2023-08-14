package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.AccountDAO;
import com.jwd39.LibraryManagement.daos.RoleDAO;
import com.jwd39.LibraryManagement.helpers.MD5Helper;
import com.jwd39.LibraryManagement.models.Accounts;
import com.jwd39.LibraryManagement.models.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class UserController {
    @GetMapping("/user/login")
    public String userLogin(Model model) {
        model.addAttribute("title", "Login");
        return "user/userLogin";
    }

    //User LogIn Control
    //------------------------------------------------------------------------------------------------------------------
    @PostMapping("/user/login")
    public String postLogIn(@RequestParam String username, String password) {
        String pswd = MD5Helper.encrypt(password);
        Accounts user = new Accounts(username, pswd);
        AccountDAO dao = new AccountDAO();
        try {
            user = dao.acLogIn(user);
        } catch (SQLException e) {
            user = null;
        }
        if (user == null) {
            return "user/login";
        } else {


            if (user.getRole_id() == 1) {
                return "admin/admin.home";
            } else {
                return "user/login";
            }

        }
    }

    @GetMapping("/user/create")
    public String userCreate(Model model) {
        model.addAttribute("title", "User Create");
        return "user/createUser";
    }

    @GetMapping("/user/view")
    public String userViewScreen() {
        return "user/userView";
    }

}
