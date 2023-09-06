package ge.tsu._5_using_stereotype_annotations;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Repository beans are the ones who manage data storage and extraction (e.g. database, filesystem)
@Repository
public class BookRepository {

    // Fake book storage (for development purposes only).
    // NOTE: It is better to use real database in 'production' application :)
    private static List<Book> books = new ArrayList<>();
    private static int ID_INCREMENT = 1;

    static {
        books.add(new Book(ID_INCREMENT++, "1984", "George Orwell"));
        books.add(new Book(ID_INCREMENT++, "Brave new World", "Aldous Huxley"));
        books.add(new Book(ID_INCREMENT++, "Fahrenheit 451", "Ray Bradbury"));
        books.add(new Book(ID_INCREMENT++, "I, Robot", "Isaac Asimov"));
    }

    public List<Book> getAll() {
        return books;
    }

    public Book getById(Integer id) {
        return books.stream()
                .filter(b -> Objects.equals(b.getId(), id))
                .findFirst().orElse(null);
    }

    public void save(Book book) {
        // Assign automatic id if book doesn't have one
        if (book.getId() == null) {
            book.setId(ID_INCREMENT++);
        }
        books.add(book);
    }

    public void remove(Book book) {
        books.removeIf(b -> Objects.equals(b.getId(), book.getId()));
    }
}
