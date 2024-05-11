package be.thomasmore.appetito.controllers.email;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("fullname") String fullname,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam("message") String message,
                            HttpSession session) {

        String subject = "Contact Form Submission";
        String body = "Full Name: " + fullname + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n\n"
                + "Message:\n" + message;

        try {
            emailService.sendMessage("testmailappetito@gmail.com", subject, body);
            session.setAttribute("success", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/contact";
    }



    @GetMapping("/contact")
    public String showContact(HttpSession session, Model model) {
        if (session.getAttribute("success") != null) {
            model.addAttribute("success", true);
            session.removeAttribute("success");


        }
        return "contact";
    }


}