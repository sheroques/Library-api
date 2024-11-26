package com.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    public BookController() {
        books.add(new Book(1L, "1984", "George Orwell", "123456789", "1949-06-08", "available"));
        books.add(new Book(2L, "Brave New World", "Aldous Huxley", "987654321", "1932-08-01", "checked out"));
    } 

    // Buscar todos os livros
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // Criar um novo livro
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book); 
        return ResponseEntity.status(201).body(book); 
    }

    // Atualizar livro
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElse(null);
                         
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublishedDate(updatedBook.getPublishedDate());
            book.setStatus(updatedBook.getStatus());
            return ResponseEntity.ok(book); 
        } else {
            return ResponseEntity.status(404).build(); 
        }
    }

    // Deletar livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElse(null);

        if (book != null) {
            books.remove(book);
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.status(404).build(); 
        }
    }
}
