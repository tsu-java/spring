package ge.tsu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String title;
    private String author;
    private String coverUrl;

    // Lombok will handle adding other constructors. We'll add only this one
    public Book(String title, String author, String coverUrl) {
        this(null, title, author, coverUrl);
    }

    // Other methods will be auto-generated: getters, setters, equals, hashCode and toString
}
