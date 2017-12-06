package jason.springexample.spring5webapp.repositories;

import jason.springexample.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
