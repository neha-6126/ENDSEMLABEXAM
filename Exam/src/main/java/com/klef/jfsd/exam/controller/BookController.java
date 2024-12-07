package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/")
    public String home()
    {
    	return "<h1>2200032696 Nithya Royal</h1>" ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> updated = bookService.updateBook(id, updatedBook);
        return updated.isPresent() 
            ? ResponseEntity.ok(updated.get()) 
            : ResponseEntity.notFound().build();
    }
}
