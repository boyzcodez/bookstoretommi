package fi.haaga.bookstoretommi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haaga.bookstoretommi.domain.AppUser;
import fi.haaga.bookstoretommi.domain.AppUserRepo;
import fi.haaga.bookstoretommi.domain.Book;
import fi.haaga.bookstoretommi.domain.BookRepository;
import fi.haaga.bookstoretommi.domain.Category;
import fi.haaga.bookstoretommi.domain.CategoryRepository;

@SpringBootApplication
public class BookstoretommiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoretommiApplication.class, args);
	}

	@Bean 
	public CommandLineRunner initRepository(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepo urepository){
		return (args) -> {
			Category audioBook = new Category();
			audioBook.setName("Audio");
			categoryRepository.save(audioBook);

			Category ebook = new Category();
			ebook.setName("Ebook");
			categoryRepository.save(ebook);

			// create book
			Book book1 = new Book(null, null, 0, null, 0, null);
			book1.setTitle("A Farewell to arms");
			book1.setAuthor("Ernest Hemingway");
			book1.setIsbn("1232323-21");
			book1.setPublicationYear(1929);
			book1.setPrice(19.99f);
			book1.setCategory(audioBook);

			// save it in the repo
			bookRepository.save(book1);

			Book book2 = new Book(null, null, 0, null, 0, null);
			book2.setTitle("Animal Farm");
			book2.setAuthor("George Orwell");
			book2.setIsbn("2212343-5");
			book2.setPublicationYear(1945);
			book2.setPrice(14.99f);
			book2.setCategory(ebook);

			// save it in the repo
			bookRepository.save(book2);

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}
