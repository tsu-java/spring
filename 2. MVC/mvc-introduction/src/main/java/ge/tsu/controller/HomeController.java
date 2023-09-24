package ge.tsu.controller;

import ge.tsu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookService service;

    @GetMapping({"/", "/home"})
    public String index(Model model) {
        model.addAttribute("books", service.getAllBook());
        return "index"; // By default, template resolver looks for view file [name].html file in '/templates' folder
    }
}
