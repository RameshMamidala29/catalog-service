package com.omnirio.catalog.service;

import com.omnirio.catalog.domain.Category;
import com.omnirio.catalog.dto.CategoryDto;

/**
 * The Interface CategoryService.
 * 
 * @author ramesh.mamidala
 */
public interface CategoryService {

  /**
   * Save category.
   *
   * @param category the category
   * @return the category
   */
  Category saveCategory(CategoryDto category);

  /**
   * Gets the category details.
   *
   * @param id the id
   * @return the category details
   */
  Category getCategoryDetails(Long id);

}
