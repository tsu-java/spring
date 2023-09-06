package ge.tsu._5_using_stereotype_annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsingStereotypeAnnotations {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(UsingStereotypeAnnotations.class, args)) {
            BookService bookService = context.getBean(BookService.class);
            System.out.println(bookService.getAllBook());

            System.out.println();
            bookService.saveBook(new Book("Master and Margarita", "Mikhail Bulgakov"));
            System.out.println(bookService.getAllBook());
        }
    }
}