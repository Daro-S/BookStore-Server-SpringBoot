package tgi.group5.bookstore.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import tgi.group5.bookstore.model.Bookstore;
import tgi.group5.bookstore.service.BookService;
@RestController
@RequestMapping("/books")
public class Bookresource {
    private final BookService bookService;
    public Bookresource(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/all")
    public ResponseEntity <List<Bookstore>> getAllBooks() {
        List<Bookstore> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Bookstore> getBookById(@PathVariable("id") long id) {
        Bookstore book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Bookstore> addBook(@RequestBody Bookstore book) {
        Bookstore newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bookstore> updateBook(@RequestBody Bookstore book) {
        Bookstore updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
