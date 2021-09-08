package com.omnirio.catalog.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.omnirio.catalog.dto.CategoryDto;
import com.omnirio.catalog.dto.ResponseEntityDto;
import com.omnirio.catalog.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Class CategoryController.
 * 
 * @author ramesh.mamidala
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category management")
public class CategoryController {

  /** The category service. */
  private final CategoryService categoryService;

  /**
   * Adds the category.
   *
   * @param category the category
   * @return the response entity
   */
  @Operation(summary = "To perform category save operation",
      description = "To save the Category.", tags = {"Category"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful save operation",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class))),
      @ApiResponse(responseCode = "500", description = "failed to save the category",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class)))})
  @PostMapping("v1/category")
  public ResponseEntity<ResponseEntityDto> addCategory(@RequestBody CategoryDto category) {
    var category1 = categoryService.saveCategory(category);
    var responseEntityDto = ResponseEntityDto.builder().data(category1)
        .message("category details saved successfully").build();
    return new ResponseEntity<>(responseEntityDto, HttpStatus.OK);
  }

  /**
   * View category.
   *
   * @param id the id
   * @return the response entity
   */
  @Operation(summary = "To perform category fetch operation by id",
      description = "To fetch the category by id.", tags = {"Category"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successfully got the category details",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class))),
      @ApiResponse(responseCode = "500", description = "failed to get the category details",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = ResponseEntityDto.class)))})
  @GetMapping("v1/category/{id}")
  public ResponseEntity<ResponseEntityDto> viewCategory(@PathVariable Long id) {
    var category = categoryService.getCategoryDetails(id);
    var responseEntityDto =
        ResponseEntityDto.builder().data(category).message("got the category details").build();
    return new ResponseEntity<>(responseEntityDto, HttpStatus.OK);
  }
}
