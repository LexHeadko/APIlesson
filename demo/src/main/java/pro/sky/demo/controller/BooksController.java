package pro.sky.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.model.Book;
import pro.sky.demo.service.BookService;

import java.util.Collection;

@RestController
@RequestMapping("books")
public class BooksController {
    @Autowired
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public ResponseEntity getBookInfo(@PathVariable long id) {
        Book book = bookService.findBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Book book1 = bookService.editBook(book);
        if (book1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(book1);
    }

    @DeleteMapping("{id}")
    public Book deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }
    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
