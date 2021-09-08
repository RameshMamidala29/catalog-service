package com.omnirio.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omnirio.catalog.domain.Product;

/**
 * The Interface ProductsRepository.
 * 
 * @author ramesh.mamidala
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {

}
