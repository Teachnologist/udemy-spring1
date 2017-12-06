package jason.springexample.spring5webapp.controllers;

import jason.springexample.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class AuthorController {

    private AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepo = authorRepository;

    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authornamespace", authorRepo.findAll());

        return "authornamespace";
    }

    @RequestMapping("/authors/deeper")
    public String getAuthorsDeeper(Model model){

        model.addAttribute("authornamespace", authorRepo.findAll());
/*if there are multiple directories under the resources templates, go directory/namespace*/
        return "deeper/authornamespace";
    }
}
