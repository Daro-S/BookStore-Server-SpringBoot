package tgi.group5.bookstore.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tgi.group5.bookstore.Exception.BookNotFoundException;
import tgi.group5.bookstore.model.Bookstore;
import tgi.group5.bookstore.repo.BookRepo;

@Service
public class BookService{
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Bookstore addBook(Bookstore book) {
        book.setIsbn(UUID.randomUUID().toString());
        return bookRepo.save(book);
    }
    
    public List<Bookstore> findAllBooks() {
        return bookRepo.findAll();
    }
    public Bookstore updateBook(Bookstore book) {
        return bookRepo.save(book);
    }
    public void deleteBook(long id){
        bookRepo.deleteBookById(id);
    }
    public Bookstore findBookById(long id){
        return bookRepo.findBookById(id).orElseThrow(() -> new BookNotFoundException("Book by Id"+ id +"was not found "));
    }

}