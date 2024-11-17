package com.contactmanager.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.contactmanager.smartcontactmanager.entity.User;
import com.contactmanager.smartcontactmanager.entity.Contact;
import com.contactmanager.smartcontactmanager.dao.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        User user = new User();
        user.setName("Jagdeep Jakhu");
        user.setPassword("1234");
        user.setAbout("my name is jagdeep jakhu.");

        Contact contact = new Contact();
        user.getContacts().add(contact);
        System.out.println("Working ...." + user);
        userRepository.save(user);

        return "Working";
    }
}
