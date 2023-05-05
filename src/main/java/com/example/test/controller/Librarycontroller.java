package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.model.User;
import com.example.test.repository.BookRepository;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class Librarycontroller {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/addbook")
    public ResponseEntity<Book> create(@RequestBody Book book){
        bookRepository.save(book);
        return ResponseEntity.ok().body(book);
    }
    @PostMapping("/adduser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book=bookRepository.findById(id).orElse(null);
//        if(book.isPresent())
            return ResponseEntity.ok().body(book);
//        else
//            return ResponseEntity.notFound().build();

//        if(book!=null){
//            return ResponseEntity.ok().body(book);
//        }
//        else {
//            return ResponseEntity.noContent().build();
//        }


    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user=userRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(user);
    }
}
