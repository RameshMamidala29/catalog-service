package com.omnirio.catalog.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.omnirio.catalog.domain.Attribute;
import com.omnirio.catalog.dto.AttributeDto;
import com.omnirio.catalog.repository.AttributesRepository;
import com.omnirio.catalog.service.AttributesService;
import com.omnirio.catalog.util.CatalogUtil;

/**
 * The Class AttributesServiceImpl.
 */
@Service
@Transactional
public class AttributesServiceImpl implements AttributesService {

  /** The attributes repository. */
  @Autowired
  private AttributesRepository attributesRepository;

  @Override
  public Attribute saveAttribute(AttributeDto attributeDto) {
    var attribute = CatalogUtil.formAttributeDto(attributeDto);
    return attributesRepository.save(attribute);
  }

}
