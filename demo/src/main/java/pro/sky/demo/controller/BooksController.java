package pro.sky.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.model.Book;
import pro.sky.demo.service.BookService;

@RestController
@RequestMapping(path = "books")
public class BooksController {
    @Autowired
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = {"id"})
    public Book getBookInfo(@PathVariable long id){
        return bookService.findBook(id);
    }

    @PostMapping
    public Book createBook(Book book) {
        return bookService.createBook(book);
    }

}
