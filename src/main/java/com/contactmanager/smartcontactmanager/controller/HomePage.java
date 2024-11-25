package com.contactmanager.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactmanager.smartcontactmanager.dao.UserRepository;
import com.contactmanager.smartcontactmanager.entity.User;

@Controller
public class HomePage {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @GetMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("title", "Register - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    // this handles for registring user
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUSer(@ModelAttribute("user") User user,
            @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {

        if (!agreement) {
            System.out.println("You have not agreed the terms and conditions");
        }
        user.setRole("ROLE_USER");
        user.setActive(true);
        user.setImageUrl("JagdeepImage.jpg");
        System.out.println("Agreement:" + agreement);
        System.out.println("User" + user);

        User result = this.userRepository.save(user);
        model.addAttribute("user", result);
        return "signup";
    }
}
