package ge.tsu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ContactController {

    @ModelAttribute("pageName")
    String pageName() {
        return "Contact Us";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String handleForm(@RequestParam("email") String email, @RequestParam("message") String message) {
        log.info("Got message to send. Email: {}, Message: {}", email, message);
        // TODO Send email or something :)
        return "contact";
    }
}
