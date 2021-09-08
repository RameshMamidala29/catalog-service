package com.omnirio.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.omnirio.catalog.dto.AttributeDto;
import com.omnirio.catalog.dto.ResponseEntityDto;
import com.omnirio.catalog.service.AttributesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Class AttributesController.
 * 
 * @author ramesh.mamidala
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "Attributes", description = "attributes management")
public class AttributesController {

  /** The attributes service. */
  private final AttributesService attributesService;

  /**
   * Adds the attributes.
   *
   * @param attributeDto the attributes
   * @return the response entity
   */
  @Operation(summary = "performs save operation",
      description = "To save the Category/Product attributes.", tags = {"Attributes"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful save operation",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class))),
      @ApiResponse(responseCode = "500", description = "failed to save the Attribute details",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class)))})
  @PostMapping("v1/attribute")
  public ResponseEntity<ResponseEntityDto> addAttributes(@RequestBody AttributeDto attributeDto) {
    var attribute = attributesService.saveAttribute(attributeDto);
    var responseEntityDto = ResponseEntityDto.builder().data(attribute)
        .message("attribute details saved successfully").build();
    return new ResponseEntity<>(responseEntityDto, HttpStatus.OK);
  }

}
