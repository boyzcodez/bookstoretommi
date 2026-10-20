package fi.haaga.bookstoretommi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haaga.bookstoretommi.web.BookController;

@SpringBootTest
class BookstoretommiApplicationTests {

	private final BookController controller;

	@Autowired
    public BookstoretommiApplicationTests(BookController controller) {
        this.controller = controller;
    }

	@Test
	void contextLoads() {
	}

	@Test
    public void controllerLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
