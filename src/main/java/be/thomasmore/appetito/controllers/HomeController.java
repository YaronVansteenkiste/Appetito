package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.services.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private GoogleService googleService;
    @GetMapping("/")
    public String Home(Model model, Principal principal) {
        final String loginName = principal != null ? principal.getName() : "anoniem";
        model.addAttribute("loginName", loginName);
        return "home";
    }

}
