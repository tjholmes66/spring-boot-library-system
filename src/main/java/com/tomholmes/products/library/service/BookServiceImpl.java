package com.tomholmes.products.library.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.products.library.model.BookEntity;
import com.tomholmes.products.library.repository.BookDao;

@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService
{
    private static final int RENEW_DAYS = 14;

    private static final Log logger = LogFactory.getLog(BookServiceImpl.class);

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    @Override
    public BookEntity create(BookEntity bookEntity)
    {
        logger.debug("create: bookEntity=" + bookEntity);
        BookEntity book = bookDao.save(bookEntity);
        return book;
    }

    @Override
    public BookEntity getById(long bookId)
    {
        BookEntity book = bookDao.findById(bookId).orElse(null);
        return book;
    }

    @Override
    public List<BookEntity> getBooksByUserId(long userId)
    {
        List<BookEntity> bookList = bookDao.findByUserId(userId);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByUsername(String username)
    {
        List<BookEntity> bookList = bookDao.findByUserName(username);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByCategory(long categoryId)
    {
        List<BookEntity> bookList = bookDao.findByCategoryId(categoryId);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByAuthor(String author)
    {
        List<BookEntity> bookList = bookDao.findByAuthorIgnoreCaseContaining(author);
        return bookList;
    }

    @Override
    public List<BookEntity> searchBooks(String author, Long categoryId)
    {
        List<BookEntity> bookList = new ArrayList<BookEntity>();
        if (author != null && categoryId != null)
        {
            bookList = bookDao.searchBooks(author, categoryId);
        }
        else if (author == null && categoryId != null)
        {
            bookList = bookDao.findByCategoryId(categoryId);
        }
        else if (author != null && categoryId == null)
        {
            bookList = bookDao.findByAuthorIgnoreCaseContaining(author);
        }
        return bookList;
    }

    @Override
    public BookEntity update(BookEntity bookEntity)
    {
        BookEntity book = bookDao.save(bookEntity);
        return book;
    }

    @Override
    public BookEntity renewBookById(long bookId)
    {
        BookEntity book = bookDao.findById(bookId).orElse(null);
        LocalDate today = LocalDate.now();
        book = bookDao.save(book);
        return book;
    }
}
