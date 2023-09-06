package ge.tsu._5_using_stereotype_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service beans contain 'business logic', the thing that drives your application (e.g. calculator logic, game engine)
// If service bean needs database access it should have it through the repository bean.
@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBook() {
        return repository.getAll();
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    // Other interesting book methods
}
