package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long>
{

	CategoryEntity findCategoryEntityByCode(String categoryCode);
  
}
