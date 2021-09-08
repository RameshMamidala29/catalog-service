/**
 * 
 */
package com.omnirio.catalog.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

/**
 * OpenAPI specification describes the entire APIs for catalog service including- available
 * endpoints and operation on each endpoint and contract information and provide interactive API
 * documentations.
 * 
 * @author ramesh.mamidala
 *
 */
@Configuration
public class OpenAPIConfig {

  /**
   * A specification includes- Swagger V3 info, title, and version with URL.
   * 
   * @return OpenAPI An API specification.
   */
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().components(new Components())
        .info(new io.swagger.v3.oas.models.info.Info().title("catalog service REST API").version("1.0")
            .license(new License().name("Omnirio").url("https://omnirio.com/")));
  }

  /**
   * Group API for Attribute end points
   * 
   * @return GroupedOpenApi Attribute apis
   */
  @Bean
  public GroupedOpenApi attributeApi() {
    return GroupedOpenApi.builder().group("Attribute API").pathsToMatch("/v1/attribute/**")
        .build();
  }
  
  /**
   * Group API for Category end points
   * 
   * @return GroupedOpenApi Category apis
   */
  @Bean
  public GroupedOpenApi categoryApi() {
    return GroupedOpenApi.builder().group("Category API").pathsToMatch("/v1/category/**")
        .build();
  }
  
  /**
   * Group API for product end points
   * 
   * @return GroupedOpenApi product apis
   */
  @Bean
  public GroupedOpenApi productApi() {
    return GroupedOpenApi.builder().group("Product API").pathsToMatch("/v1/product/**")
        .build();
  }

}
