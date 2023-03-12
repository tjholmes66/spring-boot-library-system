package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.BookEntity;

public interface BookDao extends JpaRepository<BookEntity, Long>
{
    /*
    List<BookEntity> findByUserId(long userId);
    
    List<BookEntity> findByUserName(String username);
    
    List<BookEntity> findByCategoryId(long categoryId);
    
    List<BookEntity> findByAuthor(String author);
    
    List<BookEntity> searchBooks(String author, Long categoryId);
    */
}
