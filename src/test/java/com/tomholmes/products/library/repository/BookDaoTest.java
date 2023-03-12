package com.tomholmes.products.library.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.products.library.model.BookEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookDaoTest
{
    @Autowired
    private BookDao bookDao;

    // List<BookEntity> getBooksByUserId(long userId);
    @Test
    public void testGetBooksByUser()
    {
        // long userId = 2;
        // List<BookEntity> bookList = bookDao.findByUserId(userId);
        // assertNotNull(bookList);
        // assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByUserId(long userId);
    @Test
    public void testGetBooksByUsername()
    {
        // String username = "tom@tomholmes.net";
        // List<BookEntity> bookList = bookDao.findByUserName(username);
        // assertNotNull(bookList);
        // assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByCategory(String categoryId);
    @Test
    public void testGetBooksByCategory()
    {
        // long categoryId = 4;
        // List<BookEntity> bookList = bookDao.findByCategoryId(categoryId);
        // assertNotNull(bookList);
        // assertEquals(3, bookList.size());
    }

    // List<BookEntity> getBooksByAuthor(String author);
    @Test
    public void testGetBooksByAuthor()
    {
        // String author = "Tolk";
        // List<BookEntity> bookList = bookDao.findByAuthor(author);
        // assertNotNull(bookList);
        // assertEquals(3, bookList.size());
    }

    // BookEntity update(BookEntity bookEntity);
    @Test
    public void testUpdate()
    {
        // long bookId = 2;
        // BookEntity book = bookDao.findById(bookId).orElse(null);
        // assertNotNull(book);
        // assertEquals(bookId, book.getBookId());
    }

    // BookEntity update(BookEntity bookEntity);
    @Test
    public void testGetById()
    {
        long bookId = 2;
        BookEntity book = bookDao.findById(bookId).orElse(null);
        assertNotNull(book);
        assertEquals(bookId, book.getBookId());
    }

    // List<BookEntity> getBooksByAuthor(String author);
    @Test
    public void testSearchBooks()
    {
        /*
        String author = "Tolk";
        Long categoryId = 4L;
        List<BookEntity> bookList = bookDao.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
        
        author = "Tolk";
        categoryId = 4L;
        bookList = bookDao.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(3, bookList.size());
        
        author = "TolkX";
        categoryId = 3L;
        bookList = bookDao.searchBooks(author, categoryId);
        assertNotNull(bookList);
        assertEquals(0, bookList.size());
        */
    }

}
