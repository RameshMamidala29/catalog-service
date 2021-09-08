package com.omnirio.catalog.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new attributes.
 * 
 * @author ramesh.mamidala
 */
@Data
@Getter
@Setter
public class AttributeDto implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** The id. */
  private Long attributeId;

  /** The category id. */
  private Long categoryId;
  
  /** The product id. */
  private Long productId;

  /** The name. */
  private String attributeName;

  /** The attribute value. */
  private String attributeValue;

}
