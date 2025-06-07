package com.thee5176.SpringDataJPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thee5176.SpringDataJPA.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Book findById(long id);

	Book findByIsbn(String isbn);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByTitleContaining(String keyword);
	
	List<Book> findByPriceBetween(double minPrice, double maxPrice);

	boolean existsByTitle(String title);

	boolean existsByIsbn(String title);
}