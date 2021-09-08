package com.omnirio.catalog.service;

import com.omnirio.catalog.domain.Attribute;
import com.omnirio.catalog.dto.AttributeDto;

/**
 * The Interface AttributesService.
 * 
 * @author ramesh.mamidala
 */
public interface AttributesService {

  /**
   * Save attribute.
   *
   * @param attributeDto the attributes
   * @return the attribute
   */
  Attribute saveAttribute(AttributeDto attributeDto);

}
