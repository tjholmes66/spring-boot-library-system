package com.tomholmes.products.library.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.tomholmes.products.library.model.BookEntity;
import com.tomholmes.products.library.model.UserEntity;

@SuppressWarnings("serial")
public class BookDTO implements Serializable
{
    private BookEntity book;
    private UserEntity user;
    private LocalDate dueDate;
    private boolean overdue;
    private String overDueInfo;

    public BookEntity getBook()
    {
        return book;
    }

    public void setBook(BookEntity book)
    {
        this.book = book;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public boolean isOverdue()
    {
        return overdue;
    }

    public void setOverdue(boolean overdue)
    {
        this.overdue = overdue;
    }

    public String getOverDueInfo()
    {
        return overDueInfo;
    }

    public void setOverDueInfo(String overDueInfo)
    {
        this.overDueInfo = overDueInfo;
    }

    @Override
    public String toString()
    {
        return "BookDTO [book=" + book + ", user=" + user + ", dueDate=" + dueDate + ", overdue=" + overdue + ", overDueInfo=" + overDueInfo + "]";
    }

}
