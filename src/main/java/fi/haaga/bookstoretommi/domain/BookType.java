package fi.haaga.bookstoretommi.domain;

import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity 
public class BookType {

    //Audio, Ebook, Paperbook
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long booktypeid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookType")
    private List<Book> books;

    private String myBookType;

    public Long getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Long booktypeid) {
        this.booktypeid = booktypeid;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getMyBookType() {
        return myBookType;
    }

    public void setMyBookType(String myBookType) {
        this.myBookType = myBookType;
    }

    
    

    



}
