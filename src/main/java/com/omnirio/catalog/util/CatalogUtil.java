/**
 * 
 */
package com.omnirio.catalog.util;

import java.util.HashSet;
import java.util.Set;
import com.omnirio.catalog.domain.Attribute;
import com.omnirio.catalog.domain.Category;
import com.omnirio.catalog.domain.Product;
import com.omnirio.catalog.dto.AttributeDto;
import com.omnirio.catalog.dto.CategoryDto;
import com.omnirio.catalog.dto.ProductDto;

/**
 * @author ramesh.mamidala
 *
 */
public class CatalogUtil {
  
  /**
   * Instantiates a new catalog util.
   */
  private CatalogUtil() {}
  
  /**
   * Form attribute dto.
   *
   * @param attributeDto the attribute dto
   * @return the attribute
   */
  public static Attribute formAttributeDto(AttributeDto attributeDto) {
    var attribute = new Attribute();
    attribute.setAttributeName(attributeDto.getAttributeName());
    attribute.setAttributeValue(attributeDto.getAttributeValue());
    if (null != attributeDto.getCategoryId()) 
      attribute.setCategoryId(attributeDto.getCategoryId());
    if (null != attributeDto.getProductId())
      attribute.setProductId(attributeDto.getProductId());
    return attribute;
  }
  
  /**
   * Form category.
   *
   * @param categoryDto the category dto
   * @return the category
   */
  public static Category formCategory(CategoryDto categoryDto) {
    var category = new Category();
    category.setCategoryName(categoryDto.getCategoryName());
    Set<Attribute> attributes = new HashSet<>();
    for (AttributeDto attributeDto : categoryDto.getAttributes()) {
      attributes.add(formAttributeDto(attributeDto));
    }
    category.setAttributes(attributes);
    if (null != categoryDto.getCategoryId()) 
      category.setId(categoryDto.getCategoryId());
    return category;
  }
  
  /**
   * Form product.
   *
   * @param productDto the product dto
   * @return the product
   */
  public static Product formProduct(ProductDto productDto) {
    var product = new Product();
    product.setProductName(productDto.getProductName());
    product.setCategory(formCategory(productDto.getCategory()));
    Set<Attribute> attributes = new HashSet<>();
    for (AttributeDto attributeDto : productDto.getAttributes()) {
      attributes.add(formAttributeDto(attributeDto));
    }
    product.setAttributes(attributes);
    return product;
  }

}
