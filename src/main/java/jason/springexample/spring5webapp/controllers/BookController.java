package jason.springexample.spring5webapp.controllers;

import jason.springexample.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {

    private BookRepository bookRepo;

    public BookController(BookRepository bookRepository){
        this.bookRepo = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("booknamespace", bookRepo.findAll());

        return "booknamespace";
    }
}
