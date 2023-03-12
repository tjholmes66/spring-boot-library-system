package com.tomholmes.products.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `object_book` (
 * `book_id` int NOT NULL AUTO_INCREMENT,
 * `book_name` varchar(255) DEFAULT NULL,
 * `book_description` varchar(255) DEFAULT NULL,
 * `book_author` varchar(255) DEFAULT NULL,
 * `book_pages` int DEFAULT NULL,
 * `book_published` date DEFAULT NULL,
 * `category_id` int DEFAULT NULL,
 * `book_owner_id` int NOT NULL DEFAULT '1',
 * `entered_id` int NOT NULL DEFAULT '1',
 * `entered_date` datetime NOT NULL,
 * `edited_id` int NOT NULL DEFAULT '1',
 * `edited_date` datetime DEFAULT NULL,
 * PRIMARY KEY (`book_id`),
 * KEY `fk_book_owner_idx` (`book_owner_id`),
 * CONSTRAINT `fk_book_owner` FOREIGN KEY (`book_owner_id`) REFERENCES `user` (`user_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "object_book")
public class BookEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_published")
    private LocalDate bookPublished;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_pages")
    private long bookPages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_owner_id")
    private UserEntity owner;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getBookDescription()
    {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription)
    {
        this.bookDescription = bookDescription;
    }

    public LocalDate getBookPublished()
    {
        return bookPublished;
    }

    public void setBookPublished(LocalDate bookPublished)
    {
        this.bookPublished = bookPublished;
    }

    public String getBookAuthor()
    {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor)
    {
        this.bookAuthor = bookAuthor;
    }

    public long getBookPages()
    {
        return bookPages;
    }

    public void setBookPages(long bookPages)
    {
        this.bookPages = bookPages;
    }

    public CategoryEntity getCategory()
    {
        return category;
    }

    public void setCategory(CategoryEntity category)
    {
        this.category = category;
    }

    public UserEntity getOwner()
    {
        return owner;
    }

    public void setOwner(UserEntity owner)
    {
        this.owner = owner;
    }

    public long getEnteredBy()
    {
        return enteredBy;
    }

    public void setEnteredBy(long enteredBy)
    {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredDate()
    {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate)
    {
        this.enteredDate = enteredDate;
    }

    public long getEditedBy()
    {
        return editedBy;
    }

    public void setEditedBy(long editedBy)
    {
        this.editedBy = editedBy;
    }

    public LocalDateTime getEditedDate()
    {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate)
    {
        this.editedDate = editedDate;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bookAuthor, bookDescription, bookId, bookName, bookPages, bookPublished, category, editedBy, editedDate, enteredBy, enteredDate, owner);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookEntity other = (BookEntity) obj;
        return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookDescription, other.bookDescription) && bookId == other.bookId && Objects.equals(bookName, other.bookName)
            && bookPages == other.bookPages && Objects.equals(bookPublished, other.bookPublished) && Objects.equals(category, other.category) && editedBy == other.editedBy
            && Objects.equals(editedDate, other.editedDate) && enteredBy == other.enteredBy && Objects.equals(enteredDate, other.enteredDate) && Objects.equals(owner, other.owner);
    }

    @Override
    public String toString()
    {
        return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", bookDescription=" + bookDescription + ", bookPublished=" + bookPublished + ", bookAuthor=" + bookAuthor + ", bookPages="
            + bookPages + ", category=" + category + ", owner=" + owner + ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate + ", editedBy=" + editedBy + ", editedDate=" + editedDate + "]";
    }

}
