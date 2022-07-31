package com.example.loginRolesDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value={"", "/", "index", "home"})
    public String mainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/backOffice")
    public String backOfficePage() {
        return "back-office";
    }

    @GetMapping("/professor-index")
    public String professorIndexPage() {
        return "professor-index";
    }
}
