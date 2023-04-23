package com.tomholmes.products.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.products.library.model.BookEntity;

public class BookServiceImplTest extends BaseServiceTests
{
    @Autowired
    private BookService bookService;

    // List<BookEntity> getBooksByUserId(long userId);
    @Test
    public void testGetBooksByUserId()
    {
        long userId = 2;
        List<BookEntity> bookList = bookService.getBooksByUserId(userId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByUsername(String username);
    @Test
    public void testGetBooksByUsername()
    {
        String username = "tom@tomholmes.net";
        List<BookEntity> bookList = bookService.getBooksByUsername(username);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByCategory(String categoryId);
    @Test
    public void testGetBooksByCategory()
    {
        long categoryId = 4;
        List<BookEntity> bookList = bookService.getBooksByCategory(categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByAuthor(String author);
    @Test
    public void testGetBooksByAuthor()
    {
        String author = "Tolk";
        List<BookEntity> bookList = bookService.getBooksByAuthor(author);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
    }

    // BookEntity update(BookEntity bookEntity);
    @Test
    public void testUpdate()
    {
        long bookId = 2;
        BookEntity book = bookService.getById(bookId);
        assertNotNull(book);
        assertEquals(bookId, book.getBookId());
    }

    // public BookEntity renewBookById(long bookId);
    @Test
    public void testRenewBookById()
    {
        long bookId = 2;
        BookEntity book = bookService.renewBookById(bookId);
        assertNotNull(book);
        assertEquals(bookId, book.getBookId());
    }

    // List<BookEntity> getBooksByAuthor(String author);
    @Test
    public void testSearchBooks()
    {
        String author = "Tolk";
        Long categoryId = 4L;
        List<BookEntity> bookList = bookService.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());

        author = "Tolk";
        categoryId = 3L;
        bookList = bookService.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(0, bookList.size());

        author = "TolkX";
        categoryId = 3L;
        bookList = bookService.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(0, bookList.size());

        author = "Tolk";
        categoryId = null;
        bookList = bookService.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());

        author = null;
        categoryId = 4L;
        bookList = bookService.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
    }

}
