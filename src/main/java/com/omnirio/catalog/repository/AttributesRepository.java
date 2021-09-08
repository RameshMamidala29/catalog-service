package com.omnirio.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omnirio.catalog.domain.Attribute;

/**
 * The Interface AttributesRepository.
 * 
 * @author ramesh.mamidala
 */
public interface AttributesRepository extends JpaRepository<Attribute, Long> {

}
