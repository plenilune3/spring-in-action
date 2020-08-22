package com.plenilune.tacosecurity;

import com.plenilune.tacodata.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService,
                                  PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        RegistrationForm form = new RegistrationForm();
        form.setUsername("12");
        form.setPassword("12");
        form.setFullname("12");
        form.setStreet("12");
        form.setState("12");
        form.setCity("12");
        form.setStreet("12");
        form.setZip("12");
        form.setPhone("12");
        userService.save(form.toUser(passwordEncoder));
        return "registration";
    }

//    @PostMapping(consumes = "application/json")
//    @ResponseBody
//    public String processRegistration(@RequestBody RegistrationForm form) {
//        userService.save(form.toUser(passwordEncoder));
//        return "login";
//    }
}
