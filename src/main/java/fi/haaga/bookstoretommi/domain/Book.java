package fi.haaga.bookstoretommi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Book {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // attributes: title, author, publicationYear, isbn, price

    public String title;
    public String author;
    public int publicationYear;
    public String isbn;
    public float price;

    @ManyToOne 
    @JoinColumn(name = "booktypeid")
    public BookType bookType;

        public Book() {
        }
    
    public Book(String title, String author, int publicationYear, String isbn, float price, BookType bookType) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.bookType = bookType;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "]";
    }
    public BookType getBookType() {
        return bookType;
    }
    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    
}
