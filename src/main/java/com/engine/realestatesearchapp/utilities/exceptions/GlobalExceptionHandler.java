package com.engine.realestatesearchapp.utilities.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorMessage> sendExceptionMessage(Exception ex, HttpStatus httpStatus, String url) {
        log.error(ex.getMessage());
        return ResponseEntity.status(httpStatus).body(new ErrorMessage(url, ex.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler({ServerErrorException.class})
    ResponseEntity<ErrorMessage> handle500Error(HttpServletRequest req, Exception ex) {
        return sendExceptionMessage(ex, HttpStatus.INTERNAL_SERVER_ERROR, req.getRequestURL().toString());
    }

    @ResponseBody
    @ExceptionHandler({NotFoundException.class})
    ResponseEntity<ErrorMessage> handle404Error(HttpServletRequest req, Exception ex) {
        return sendExceptionMessage(ex, HttpStatus.NOT_FOUND, req.getRequestURL().toString());
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    ResponseEntity<ErrorMessage> handle401Error(HttpServletRequest req, Exception ex) {
        return sendExceptionMessage(ex, HttpStatus.UNAUTHORIZED, req.getRequestURL().toString());
    }

    @ResponseBody
    @ExceptionHandler({InvalidRequestException.class, Exception.class, AlreadyExistsException.class})
    ResponseEntity<ErrorMessage> handle400(HttpServletRequest req, Exception ex) {
        return sendExceptionMessage(ex, HttpStatus.BAD_REQUEST, req.getRequestURL().toString());
    }

}
