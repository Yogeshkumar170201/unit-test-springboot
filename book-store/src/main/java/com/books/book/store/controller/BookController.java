package com.books.book.store.controller;

import com.books.book.store.model.Book;
import com.books.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<HashMap<String, String>> addBook(@RequestBody Book book){
        HashMap<String, String> res = new HashMap<>();
        try {
            bookService.addBook(book);
            res.put("message", "Book Successfully added");
            return ResponseEntity.ok(res);

        }catch(Exception e){
            res.put("message", e.getMessage());
        }

        return ResponseEntity.ok(res);

    }


    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        HashMap<String, List<Book>> res = new HashMap<>();
        return bookService.getAllBooks();
    }

    @DeleteMapping("/deleteBook/{name}")
    public ResponseEntity<HashMap<String, String>> deleteBook(@PathVariable("name") String name){
        HashMap<String, String> res = new HashMap<>();
        try{
            bookService.deleteBook(name);
            res.put("message", "Book deleted successfully");
        }catch (Exception e){
            res.put("message", e.getMessage());
        }
        return ResponseEntity.ok(res);

    }

    @PutMapping("/editBook/{name}")
    public ResponseEntity<HashMap<String, String>> updateBook(@RequestBody Book book, @PathVariable("name") String name){
        HashMap<String, String> res = new HashMap<>();
        try{
            bookService.updateBook(book, name);
            res.put("message", "Book Updated successfully");
        }catch (Exception e){
            res.put("message", e.getMessage());
        }
        return ResponseEntity.ok(res);
    }



}
