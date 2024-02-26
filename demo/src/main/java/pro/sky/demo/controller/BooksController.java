package pro.sky.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.model.Book;
import pro.sky.demo.service.BookService;

@RestController
@RequestMapping("books")
public class BooksController {
    @Autowired
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public Book getBookInfo(@PathVariable long id) {
        return bookService.findBook(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping
    public Book editBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

    @DeleteMapping("{id}")
    public Book deleteBook(@PathVariable long id ) {
        return bookService.deleteBook(id);
    }
}
