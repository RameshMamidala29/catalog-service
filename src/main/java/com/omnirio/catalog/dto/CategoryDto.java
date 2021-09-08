package com.omnirio.catalog.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new category.
 * 
 * @author ramesh.mamidala
 */
@Data
@Getter
@Setter
public class CategoryDto implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** The id. */
  private Long categoryId;

  /** The name. */
  private String categoryName;

  /** The attributes. */
  private Set<AttributeDto> attributes = new HashSet<>();

}
