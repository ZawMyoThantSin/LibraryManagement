package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.AccountDAO;
import com.jwd39.LibraryManagement.models.Accounts;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class UserController {
    @GetMapping("/user/login")
    public String userLogin(Model model){
        model.addAttribute("title","Login");
        return "user/userLogin";
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestParam String name, String password,
                            HttpSession session,Model model) throws SQLException {
        Accounts user = new AccountDAO().userValidate(name,password);
            System.out.println(user);
           if (user!=null){
               int roleId = user.getRole_id();
               switch (roleId){
                   case 1:
                       session.setAttribute("admin",user);
                       return "admin/admin.home";
                   case 2:
                       session.setAttribute("user",user);
                       return "user/userView";
               }
           }else
             model.addAttribute("message", "User Name and Password is Invalid!");
             return "user/userLogin";

    }

    @GetMapping("/user/registration")
    public String userCreate(Model model){
        model.addAttribute("title","User Create");
        return "user/userRegistration";
    }
    @PostMapping("/user/registration")
    public String userCreate(@RequestParam String name,String email,String password,int roleId) throws SQLException {
        Accounts user = new Accounts(name,email,password,roleId);
        int status = new AccountDAO().acRegister(user);
        if(status==1){
            return "user/userView";
        }

        return "user/userRegistration";
    }

    @GetMapping("/user/view")
    public String userViewScreen(){
        return "user/userView";
    }

}
