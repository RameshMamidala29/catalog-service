package com.omnirio.catalog.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new products.
 * 
 * @author ramesh.mamidala
 */
@Data
@Entity
@Table(name = "product")
@Setter
@Getter
public class Product implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** The name. */
  @Column(name = "product_name")
  private String productName;

  /** The category. */
  @OneToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;
  
  /** The attributes. */
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id")
  private Set<Attribute> attributes = new HashSet<>();

}
