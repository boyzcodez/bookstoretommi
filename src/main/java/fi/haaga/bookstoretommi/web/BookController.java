package fi.haaga.bookstoretommi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haaga.bookstoretommi.domain.Book;
import fi.haaga.bookstoretommi.domain.BookRepository;
import fi.haaga.bookstoretommi.domain.BookTypeRepository;
import fi.haaga.bookstoretommi.domain.BookType;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private BookTypeRepository bookTypeRepository;

    public BookController(BookRepository bookRepository, BookTypeRepository bookTypeRepository){
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
    }

    @RequestMapping("/index")
    public String showIndex(Model model){

        // print repo into terminal

        List<Book> bookList = (ArrayList<Book>) bookRepository.findAll();

        model.addAttribute("books", bookList);

        System.out.println("TOMMIN DEBUGAUS");

        List<Book> books = (List<Book>) bookRepository.findAll();

        for (int i = 0; i < books.size(); i++){
            BookType bookType = books.get(i).getBookType();
            System.out.println(bookType == null ? null : bookType);
        }


        return "booklist";
    }

    @RequestMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("bookTypes", bookTypeRepository.findAll());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(Book book, @RequestParam Long bookTypeId) {
        book.setBookType(bookTypeRepository.findById(bookTypeId).orElseThrow());

        bookRepository.save(book);
        
        return "redirect:/index";
    }
    

    @GetMapping("/deletebook/{id}")
    public String deleteUser(@PathVariable Long id) {
        bookRepository.deleteById(id);

        return "redirect:/index";
    }

    @RequestMapping("/editbook/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();

        model.addAttribute("book", book);
        model.addAttribute("bookTypes", bookTypeRepository.findAll());

        return "editbook";
    }

    @PostMapping("/editbook/{id}")
    public String editBook(@PathVariable Long id, Book updatedBook, @RequestParam Long bookTypeId) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPublicationYear(updatedBook.getPublicationYear());
        book.setIsbn(updatedBook.getIsbn());
        book.setPrice(updatedBook.getPrice());
        book.setBookType(bookTypeRepository.findById(bookTypeId).orElseThrow());
        bookRepository.save(book);

        return "redirect:/index";
    }
}
