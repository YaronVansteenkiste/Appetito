package be.thomasmore.appetito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class XDagenMenuController {
    @GetMapping("/x-dagenmenu")
        public String xdagenmenu(Model model){
        return "menu";
    }
}
