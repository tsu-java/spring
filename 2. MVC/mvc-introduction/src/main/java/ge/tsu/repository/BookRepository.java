package ge.tsu.repository;

import ge.tsu.model.Book;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Repository beans are the ones who manage data storage and extraction (e.g. database, filesystem)
@Repository
@Description("Repository bean that contains fake storage logic")
public class BookRepository {

    // Fake book storage (for development purposes only).
    // NOTE: It is better to use real database in 'production' application :)
    private static List<Book> books = new ArrayList<>();
    private static int ID_INCREMENT = 1;

    static {
        books.add(new Book(ID_INCREMENT++, "1984", "George Orwell",
                "https://i.pinimg.com/736x/0d/2c/09/0d2c0915b3c86c8ac0680f3f6c88731d.jpg"));
        books.add(new Book(ID_INCREMENT++, "Brave new World", "Aldous Huxley",
                "https://diwanegypt.com/wp-content/uploads/2020/08/9780099477464.jpg"));
        books.add(new Book(ID_INCREMENT++, "Fahrenheit 451", "Ray Bradbury",
                "https://i.pinimg.com/originals/0b/c9/1a/0bc91a7a29b03967614ef5ce157ee53e.jpg"));
        books.add(new Book(ID_INCREMENT++, "I, Robot", "Isaac Asimov",
                "https://prodimage.images-bn.com/pimages/9780553900330_p0_v2_s1200x630.jpg"));
    }

    public List<Book> getAll() {
        return books;
    }

    public Book findById(Integer id) {
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
