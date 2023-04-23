package com.tomholmes.products.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.BookEntity;

public interface BookDao extends JpaRepository<BookEntity, Long>
{
    @Query(value = "from BookEntity b where (b.owner.userId = :userId)")
    List<BookEntity> findByUserId(long userId);

    // @Query(value = "from BookEntity b where (upper(b.author) LIKE :author)")
    List<BookEntity> findByAuthorIgnoreCaseContaining(String author);

    @Query(value = "from BookEntity b where (b.category.categoryId = :categoryId)")
    List<BookEntity> findByCategoryId(long categoryId);

    @Query(value = "from BookEntity b where (b.owner.username = :username)")
    List<BookEntity> findByUserName(String username);

    @Query(value = "from BookEntity b where (upper(b.author) LIKE %:author%) AND (b.category.categoryId = :categoryId)")
    List<BookEntity> searchBooks(String author, Long categoryId);
}
