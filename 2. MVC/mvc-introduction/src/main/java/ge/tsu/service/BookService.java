package ge.tsu.service;

import ge.tsu.model.Book;
import ge.tsu.repository.BookRepository;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Description("Service bean that contains Books' business logic")
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBook() {
        return repository.getAll();
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    public Book getSingleBookById(Integer bookId) {
        return repository.findById(bookId);
    }
}
