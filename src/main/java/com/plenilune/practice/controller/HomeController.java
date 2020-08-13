package com.plenilune.practice.controller;

import com.plenilune.practice.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "home";
    }

}
