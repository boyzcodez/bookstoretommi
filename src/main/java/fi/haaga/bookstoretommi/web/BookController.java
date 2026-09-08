package fi.haaga.bookstoretommi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haaga.bookstoretommi.domain.Book;
import fi.haaga.bookstoretommi.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/index")
    public String showIndex(Model model){

        // print repo into terminal

        List<Book> bookList = (ArrayList<Book>) bookRepository.findAll();

        model.addAttribute("books", bookList);


        return "booklist";
    }

    @RequestMapping("/addbook")
    public String addBookForm() {        
        return "addbook";
    }

    @PostMapping("/addbook")
    public String AddBook(Book book) {

        bookRepository.save(book);
        
        return "redirect:/index";
    }
    

    @GetMapping("/deletebook/{id}")
    public String deleteUser(@PathVariable Long id) {
        bookRepository.deleteById(id);

        return "redirect:/index";
    }
    
}
