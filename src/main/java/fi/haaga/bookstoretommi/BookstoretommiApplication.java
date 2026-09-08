package fi.haaga.bookstoretommi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haaga.bookstoretommi.domain.Book;
import fi.haaga.bookstoretommi.domain.BookRepository;

@SpringBootApplication
public class BookstoretommiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoretommiApplication.class, args);
	}

	@Bean 
	public CommandLineRunner initRepository(BookRepository bookRepository){
		return (args) -> {
			// create book
			Book book1 = new Book();
			book1.setTitle("A Farewell to arms");
			book1.setAuthor("Ernest Hemingway");
			book1.setIsbn("1232323-21");
			book1.setPublicationYear(1929);
			book1.setPrice(19.99f);

			// save it in the repo
			bookRepository.save(book1);

			Book book2 = new Book();
			book2.setTitle("Animal Farm");
			book2.setAuthor("George Orwell");
			book2.setIsbn("2212343-5");
			book2.setPublicationYear(1945);
			book2.setPrice(14.99f);

			// save it in the repo
			bookRepository.save(book2);
		};
	}

}
