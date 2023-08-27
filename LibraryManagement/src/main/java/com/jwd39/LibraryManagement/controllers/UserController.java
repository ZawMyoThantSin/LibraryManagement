package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.helpers.SHA_256Helper;
import com.jwd39.LibraryManagement.models.Account;
import com.jwd39.LibraryManagement.services.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/login")
    public String userLogin(Model model){
        model.addAttribute("title","Login");
        return "user/userLogin";
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestParam String name, String password,HttpSession session,Model model) {
        String pass = SHA_256Helper.encrypt(password);
        Account user = accountService.validate(name,pass);
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
        model.addAttribute("title","User Registration");
        return "user/userRegistration";
    }

    @PostMapping("/user/registration")
    public String userCreate(@RequestParam String name,String email,String password,int roleId) {
        Account user = new Account(name,email,password,roleId);
        int status = accountService.save(user);
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
