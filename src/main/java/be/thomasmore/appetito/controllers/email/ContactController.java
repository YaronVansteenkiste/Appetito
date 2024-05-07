package be.thomasmore.appetito.controllers.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ModelAndView sendEmail(@RequestParam("fullname") String fullname,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("message") String message,
                                  RedirectAttributes redirectAttributes) {



        String subject = "Contact Form Submission";
        String body = "Full Name: " + fullname + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n\n"
                + "Message:\n" + message;


        emailService.sendMessage("testmailappetito@gmail.com", subject, body);



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        redirectAttributes.addAttribute("success", true);
        return modelAndView;
    }

        @GetMapping({"/contact"})
        public String showContact() {

            return "contact";
        }

}