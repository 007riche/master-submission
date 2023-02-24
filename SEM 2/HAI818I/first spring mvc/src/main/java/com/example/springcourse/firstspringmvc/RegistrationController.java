package com.example.springcourse.firstspringmvc;

import jakarta.mvc.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

//    @GetMapping("/")
//    public String getIndex() {
//        return "index";
//    }

//    @RequestMapping(value = "registration", method = RequestMethod.GET)
    @GetMapping("registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration() {
        return "registration";
    }
}
