package com.omnirio.catalog.dto;

import lombok.Builder;
import lombok.Data;

/**
 * The ResponseEntityDto POJO
 * 
 * @author ramesh.mamidala
 *
 */
@Data
@Builder
public class ResponseEntityDto {

  /**
   * Message to be displayed on UI
   */
  private String message;

  /**
   * The response content
   */
  private Object data;

  /**
   * The response totalRecords
   */
  private Integer totalRecords;

}
