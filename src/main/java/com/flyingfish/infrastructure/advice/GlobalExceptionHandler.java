package com.flyingfish.infrastructure.advice;

import com.flyingfish.exception.AccountExistsException;
import com.flyingfish.infrastructure.web.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception ex, HttpServletRequest req) {
        if (ex instanceof AccountExistsException) {
            logger.error(((AccountExistsException) ex).getMessage(), ex);
            return new Response(((AccountExistsException) ex).getErrorCode(), ((AccountExistsException) ex).getMessage());
        } else {
            logger.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
    }
}
