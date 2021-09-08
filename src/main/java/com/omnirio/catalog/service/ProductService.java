package com.omnirio.catalog.service;

import com.omnirio.catalog.domain.Product;
import com.omnirio.catalog.dto.ProductDto;

/**
 * The Interface ProductService.
 * 
 * @author ramesh.mamidala
 */
public interface ProductService {

  /**
   * Save product.
   *
   * @param products the products
   * @return the product
   */
  Product saveProduct(ProductDto products);

  /**
   * Gets the product details.  
   *
   * @param id the id
   * @return the product details
   */
  Product getProductDetails(Long id);

}
