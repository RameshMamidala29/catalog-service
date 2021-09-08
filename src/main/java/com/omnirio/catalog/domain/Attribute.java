package com.omnirio.catalog.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new attributes.
 * 
 * @author ramesh.mamidala
 */

/**
 * Instantiates a new attribute.
 */

/**
 * Instantiates a new attribute.
 */
@Data
@Entity
@Table(name = "attribute")

/**
 * Gets the attribute value.
 *
 * @return the attribute value
 */
@Getter

/**
 * Sets the attribute value.
 *
 * @param attributeValue the new attribute value
 */
@Setter
public class Attribute implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long attributeId;

  /** The category id. */
  @Column(name = "category_id")
  private Long categoryId;
  
  /** The product id. */
  @Column(name = "product_id")
  private Long productId;

  /** The name. */
  @Column(name = "attribute_name")
  private String attributeName;

  /** The attribute value. */
  @Column(name = "attribute_value")
  private String attributeValue;

}
