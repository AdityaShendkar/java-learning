package com.exceptionhandling.productexception;

import com.exceptionhandling.productentity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        System.out.println("GlobalExceptionHandler Loaded...");
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handle(Exception ex) {
//
//        System.out.println("Generic Handler Executed");
//
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ex.getMessage());
//    }

    @ExceptionHandler(DuplicateProductException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(
            DuplicateProductException ex) {

        System.out.println("Creating ErrorResponse");

        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                "details",
                "DUPLICATE PRODUCT");

        System.out.println(error);

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductNotFoundException ex) {

        System.out.println("Not Found Handler Called");

        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                "details",
                "PRODUCT NOT FOUND IN DB");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
