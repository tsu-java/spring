package ge.tsu.controller;

import ge.tsu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/book/{id}")
    public String allBooks(@PathVariable("id") Integer bookId, Model model) {
        var book = service.getSingleBookById(bookId);
        model.addAttribute("pageName", book.getTitle());
        model.addAttribute("book", book);
        return "book";
    }
}
