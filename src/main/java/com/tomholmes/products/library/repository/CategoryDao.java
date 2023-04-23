package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long>
{
    @Query(value = "from CategoryEntity category where (category.categoryCode = :categoryCode)")
    CategoryEntity findCategoryEntityByCode(String categoryCode);
}
