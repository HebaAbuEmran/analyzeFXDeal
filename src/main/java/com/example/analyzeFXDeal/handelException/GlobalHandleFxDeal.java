package com.example.analyzeFXDeal.handelException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandleFxDeal {

    @ExceptionHandler(FxDealSameRequest.class)
    public ResponseEntity<Object> processFxDealException(FxDealSameRequest fxDealSameRequest){

        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", fxDealSameRequest.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.CONFLICT);

    }

}
