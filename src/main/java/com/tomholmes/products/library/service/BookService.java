package com.tomholmes.products.library.service;

import java.util.List;

import com.tomholmes.products.library.model.BookEntity;

public interface BookService
{
    // CREATE
    BookEntity create(BookEntity bookEntity);

    // RETRIEVE
    BookEntity getById(long bookId);

    List<BookEntity> getBooksByUserId(long userId);

    List<BookEntity> getBooksByUsername(String username);

    List<BookEntity> getBooksByCategory(long categoryId);

    List<BookEntity> getBooksByAuthor(String author);

    List<BookEntity> searchBooks(String author, Long categoryId);

    // UPDATE
    BookEntity update(BookEntity bookEntity);

    BookEntity renewBookById(long bookId);

    // DELETE
}
