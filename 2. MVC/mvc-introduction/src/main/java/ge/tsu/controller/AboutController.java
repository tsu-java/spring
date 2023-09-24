package ge.tsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AboutController {

    @ModelAttribute("pageName")
    String pageName() {
        return "About Us";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
