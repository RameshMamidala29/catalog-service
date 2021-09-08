package com.omnirio.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.omnirio.catalog.dto.ProductDto;
import com.omnirio.catalog.dto.ResponseEntityDto;
import com.omnirio.catalog.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Class ProductController.
 * 
 * @author ramesh.mamidala
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "Product", description = "product management")
public class ProductController {

  /** The product service. */
  private final ProductService productService;

  /**
   * Adds the product.
   *
   * @param products the products
   * @return the response entity
   */
  @Operation(summary = "To perform product save operation",
      description = "To save the product.", tags = {"Product"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful save operation",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class))),
      @ApiResponse(responseCode = "500", description = "failed to save the product details",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class)))})
  @PostMapping("v1/product")
  public ResponseEntity<ResponseEntityDto> addProduct(@RequestBody ProductDto products) {
    var product = productService.saveProduct(products);
    var responseEntityDto = ResponseEntityDto.builder().data(product)
        .message("prodapt details saved successfully").build();
    return new ResponseEntity<>(responseEntityDto, HttpStatus.OK);
  }

  /**
   * View product.
   *
   * @param id the id
   * @return the response entity
   */
  @Operation(summary = "To perform product fetch operation",
      description = "To get the product.", tags = {"Product"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successfully got the product",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class))),
      @ApiResponse(responseCode = "500", description = "failed to get the product details",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class)))})
  @GetMapping("v1/product/{id}")
  public ResponseEntity<ResponseEntityDto> viewProduct(@PathVariable Long id) {
    var product = productService.getProductDetails(id);
    var responseEntityDto =
        ResponseEntityDto.builder().data(product).message("got the product details").build();
    return new ResponseEntity<>(responseEntityDto, HttpStatus.OK);
  }
}
