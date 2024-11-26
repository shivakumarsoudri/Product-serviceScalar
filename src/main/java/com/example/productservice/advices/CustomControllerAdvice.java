package com.example.productservice.advices;

import com.example.productservice.dtos.ErrorDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNPEexception() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("something went wrong");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(
                errorDto, HttpStatusCode.valueOf(500)
        );
        return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handlePNPEexception(){
        ErrorDto errorDto =new ErrorDto();
        errorDto.setMessage("Product Not found.please try again");
        ResponseEntity<ErrorDto> responseEntity =new ResponseEntity<>(
                errorDto,HttpStatusCode.valueOf(404)
        );
        return responseEntity;
    }
    @ExceptionHandler(Exception.class)
    public void handleAllExceptions(){

    }

}
