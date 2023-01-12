package com.example.springbootlibrary.controller;


import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkBookByUser(@RequestParam Long bookId) {
        String userEmail = "test@email.com";
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(){
        String userEmail = "test@email.com";
        return bookService.currentLoansCount(userEmail);
    }
    @PutMapping("/secure/checkout")
    public Book checkoutBook (@RequestParam Long bookId) throws Exception {
        String userEmail = "test@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }
}
