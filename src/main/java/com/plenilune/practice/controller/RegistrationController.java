package com.plenilune.practice.controller;

import com.plenilune.practice.dto.RegistrationForm;
import com.plenilune.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public RegistrationController(PasswordEncoder passwordEncoder,
                                  UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userService.userRegistration(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
