package com.example.loginRolesDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping(value={"", "/", "index", "home"})
    public String mainPage() {
        return "pages/index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "pages/login";
    }

    @GetMapping(value={"/backOffice", "/back-office", "/professor-index"})
    public String backOfficePage() {
        return "back-office/index";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "pages/profile";
    }
}
