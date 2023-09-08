package com.erfer.finctrl.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erfer.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}