package com.omnirio.catalog.exception;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.omnirio.catalog.dto.ResponseEntityDto;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Common exception handler to handle all API exceptions
 *
 * @author ramesh.mamidala
 */
@Slf4j
@ControllerAdvice
public class CatalogApiExceptionHandler {

  /**
   * To handle the generic exceptions
   * 
   * @param ex : The exception
   * @param request : The request
   * @return : Response entity
   */
  @ExceptionHandler({Exception.class})
  public ResponseEntity<ResponseEntityDto> handleAll(Exception ex, HttpServletRequest request) {

    log.error(ex.getLocalizedMessage(), ex);
    var apiResponse =
        buildResponseEntityDto(ex.getLocalizedMessage(), Map.of("error", ex.getLocalizedMessage()));

    return ResponseEntity.internalServerError().body(apiResponse);
  }

  /**
   * Builds common response entity
   * 
   * @param message : Message for UI display
   * @param error : Error message
   * @return : response entity
   */
  private ResponseEntityDto buildResponseEntityDto(String message, Object error) {
    return ResponseEntityDto.builder().message(message).data(error).build();
  }

}
