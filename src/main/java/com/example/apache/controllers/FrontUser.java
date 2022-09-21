package com.example.apache.controllers;

import com.example.apache.entities.User;
import com.example.apache.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class FrontUser {
    UserService services;

    public FrontUser(UserService services){
        this.services =services;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/frontUser")
    public String index(Model model){
        List<User> usuarios = this.services.getUserList();
        model.addAttribute("usuarios",usuarios);
        return "user";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("usuario", new User());
        return "form";
    }
    @PostMapping("/save")
    public String save(User user, Model model){
        services.save(user);
        return "redirect:/frontUser";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable long id,  Model model){
        Optional<User> user = services.getUserId(id);
        model.addAttribute("usuario", user);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id,Model model){
        services.deleteUserId(id);
        return "redirect:/frontUser";
    }

}
