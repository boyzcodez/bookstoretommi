package fi.haaga.bookstoretommi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haaga.bookstoretommi.domain.Book;
import fi.haaga.bookstoretommi.domain.BookRepository;
import fi.haaga.bookstoretommi.web.BookController;

@SpringBootTest

public class BookRepositoryTest {

    private final BookRepository repo;

	@Autowired
    public BookRepositoryTest(BookRepository repo) {
        this.repo = repo;
    }

    // @Test
    // public void HasTitle() throws Exception {
    //     assertThat(repo.findByTitle("A Farewell to arms")).isNotNull();
    // }

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repo.findByTitle("A Farewell to arms");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
    }

    @Test 
    public void CreateBook() {
        Book book1 = new Book(null, null, 0, null, 0, null);
        book1.setTitle("A Testful of Test");
        book1.setAuthor("Tommi Korhonen");
        book1.setIsbn("9898989-98");
        book1.setPublicationYear(2026);
        book1.setPrice(99.99f);

        repo.save(book1);

        assertThat(book1.getId()).isNotNull();
    }

    @Test void DeleteBook() {
        List<Book> books = repo.findByTitle("A Farewell to arms");
        assertThat(books).hasSize(1);

        Book book = books.get(0);

        repo.delete(book);

        assertThat(repo.findByTitle("A Farewell to arms")).isEmpty();
    }
}
