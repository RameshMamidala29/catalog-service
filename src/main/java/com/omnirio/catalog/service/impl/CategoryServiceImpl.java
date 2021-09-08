package com.omnirio.catalog.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.omnirio.catalog.domain.Category;
import com.omnirio.catalog.dto.CategoryDto;
import com.omnirio.catalog.repository.CategoryRepository;
import com.omnirio.catalog.service.CategoryService;
import com.omnirio.catalog.util.CatalogUtil;

/**
 * The Class CategoryServiceImpl.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  /** The category repository. */
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category saveCategory(CategoryDto categoryDto) {
    var category = CatalogUtil.formCategory(categoryDto);
    return categoryRepository.save(category);
  }

  @Override
  public Category getCategoryDetails(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    if (category.isPresent()) {
      return category.get();
    }
    return null;
  }
}
