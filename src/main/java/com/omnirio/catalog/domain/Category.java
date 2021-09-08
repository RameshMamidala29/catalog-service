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
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new category.
 * 
 * @author ramesh.mamidala
 */
@Data
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category implements Serializable {

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
  @Column(name = "category_name")
  private String categoryName;

  /**
   * The attributes
   */
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  private Set<Attribute> attributes = new HashSet<>();


}
