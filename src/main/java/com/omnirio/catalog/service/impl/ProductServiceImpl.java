package com.omnirio.catalog.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.omnirio.catalog.domain.Product;
import com.omnirio.catalog.dto.ProductDto;
import com.omnirio.catalog.repository.ProductsRepository;
import com.omnirio.catalog.service.ProductService;
import com.omnirio.catalog.util.CatalogUtil;

/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  /** The product repository. */
  @Autowired
  private ProductsRepository productRepository;

  @Override
  public Product saveProduct(ProductDto productDto) {
    var products = CatalogUtil.formProduct(productDto);
    return productRepository.save(products);
  }

  @Override
  public Product getProductDetails(Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (product.isPresent()) {
      return product.get();
    }
    return null;
  }
}
