package com.flyingfish.infrastructure.web;

import org.springframework.http.HttpStatus;

import java.util.Collection;

public class Response {
    private int code;
    private String message;
    private Object data;

    public Response() {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
    }

    public Response(Object data) {
        if (data == null || data instanceof Collection && ((Collection) data).isEmpty()) {
            this.code = HttpStatus.NO_CONTENT.value();
            this.message = HttpStatus.NO_CONTENT.getReasonPhrase();
        } else {
            this.code = HttpStatus.OK.value();
            this.message = HttpStatus.OK.getReasonPhrase();
            this.data = data;
        }
    }

    public Response(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
