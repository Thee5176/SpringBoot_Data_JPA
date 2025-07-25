package com.thee5176.SpringDataJPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thee5176.SpringDataJPA.Entity.Book;
import com.thee5176.SpringDataJPA.Repository.BookRepository;


@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		// Check if book with the same ISBN or title already exists
		if (!bookRepository.existsByIsbn( book.getTitle() ) || !bookRepository.existsByTitle( book.getTitle() )) {
			bookRepository.save(book);
		} else {
			return ResponseEntity.badRequest().body("Book with title '" + book.getTitle() + "' already exists.");
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/books/search")
	public Book getBookById(@RequestParam long id) {
		return bookRepository.findById(id);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@PutMapping("/books/{id}")
	public Book updateBooks(@PathVariable long id, @RequestBody Book book) {
		book.setId(id);
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBooks(@PathVariable long id) {
			Book book = bookRepository.findById(id);
			bookRepository.delete(book);
		return ResponseEntity.ok().build();
	}
	
}
