package com.omnirio.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omnirio.catalog.domain.Category;

/**
 * The Interface CategoryRepository.
 * 
 * @author ramesh.mamidala
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
