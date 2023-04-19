package com.example.goods.exception;

import com.example.goods.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GoodsExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        List<ObjectError> errorList=ex.getBindingResult().getAllErrors();
        List<String> errMsg=errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO =new ResponseDTO("Exception Occured", errMsg.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(GoodsException.class)
    public ResponseEntity<ResponseDTO> handleException(GoodsException ex)
    {
        ResponseDTO responseDTO =new ResponseDTO("Exception Occured",ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_GATEWAY);
    }
}
