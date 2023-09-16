package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.helpers.SHA_256Helper;
import com.jwd39.LibraryManagement.impls.BookRecent;
import com.jwd39.LibraryManagement.models.Account;
import com.jwd39.LibraryManagement.models.AccountsReadsBooks;
import com.jwd39.LibraryManagement.services.AccountService;
import com.jwd39.LibraryManagement.services.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/user/login")
    public String userLogin(@RequestParam String email, String password,HttpSession session,Model model) {
        Account user = accountService.validate(email,password);
        if (user!=null){
            int roleId = user.getRole_id();
            switch (roleId){
                case 1:
                    session.setAttribute("admin",user);
                    return "redirect:/admin/home";
                case 2:
                    session.setAttribute("user",user);
                    return "redirect:/user/home";
            }
        }else
            model.addAttribute("message", "Your email or password is Invalid!");
        return "user/userLogin";
    }

    @GetMapping("/user/registration")
    public String userCreate(Model model){
        Account account = new Account();

        model.addAttribute("title","Registration");
        model.addAttribute("account",account);
        return "user/userRegistration";
    }


    @PostMapping("/user/registration")
    public String userCreate(@RequestParam String name, String email, String password, String cfpassword, int roleId, Model model) {
        Account user = new Account(name, email, password, roleId);
        if (!cfpassword.equalsIgnoreCase(password)) {
            model.addAttribute("message", "Your password does not match. Please try again !!!");
            return "user/userRegistration";
        } else {
            boolean confirm = accountService.emailConfirm(user.getEmail());
            if (confirm) {
                model.addAttribute("message", "Your email is already existed!!!");
                return "user/userRegistration";
            } else {
                int status = accountService.save(user);
                if (status == 1) {
                    return "redirect:/user/home";
                } else {
                    return "redirect:/user/registration";
                }
            }
        }
    }

    @GetMapping("/user/recent")
    public String BookRecent(Model model){
        BookRecent recent = new BookRecent();
        List<AccountsReadsBooks> recents = recent.getRecentList(2);
        model.addAttribute("recents",recents);
        return "user/userRecent";
    }

}