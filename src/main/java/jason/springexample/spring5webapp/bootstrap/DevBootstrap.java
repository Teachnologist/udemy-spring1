package jason.springexample.spring5webapp.bootstrap;

import jason.springexample.spring5webapp.model.Book;
import jason.springexample.spring5webapp.model.Author;
import jason.springexample.spring5webapp.model.Publisher;
import jason.springexample.spring5webapp.repositories.AuthorRepository;
import jason.springexample.spring5webapp.repositories.BookRepository;
import jason.springexample.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepo;
    private BookRepository bookRepo;
    private PublisherRepository publisherRepo;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepo = authorRepository;
        this.bookRepo = bookRepository;
        this.publisherRepo = publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Publisher randomHouse = new Publisher("Random House","1234 Main St","Indianapolis","Indiana","31751");
        publisherRepo.save(randomHouse);

        Author ben = new Author("Ben", "Peter");
        Book bensbook = new Book("God Bless Bro","139",randomHouse);
        ben.getBooks().add(bensbook);
        bensbook.getAuthors().add(ben);

        authorRepo.save(ben);
        bookRepo.save(bensbook);

        Publisher randomHouse2 = new Publisher("Random House2","1234 South St","Milwaukee","Wisconsin","50505");
        publisherRepo.save(randomHouse2);
        randomHouse.setName("Second Random Entry");
        publisherRepo.save(randomHouse);


        Author brandon = new Author("Brandon", "Jason");
        Book brandonsbook = new Book("God Bless You","108",randomHouse2);
        brandon.getBooks().add(brandonsbook);
        brandonsbook.getAuthors().add(brandon);

        authorRepo.save(brandon);
        bookRepo.save(brandonsbook);

    }
}
