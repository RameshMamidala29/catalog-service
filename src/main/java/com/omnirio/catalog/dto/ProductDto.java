package com.omnirio.catalog.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new products.
 * 
 * @author ramesh.mamidala
 */
@Data
@Setter
@Getter
public class ProductDto implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** The id. */
  private Long productId;

  /** The name. */
  private String productName;

  /** The category. */
  private CategoryDto category;
  
  /** The attributes. */
  private Set<AttributeDto> attributes = new HashSet<>();

}
