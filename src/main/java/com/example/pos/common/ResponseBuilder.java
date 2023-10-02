package com.example.pos.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ResponseBuilder<T> {
    // ResponseEntity stuff
    private HttpStatus status;
    private final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

    // ResponseBody stuff
    private String code;
    private String message;
    private T data;

    public ResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }
    public ResponseBuilder<T> status(HttpStatus status) {
        this.status = status;
        return this;
    }
    public ResponseBuilder<T> code(String code) {
        this.code = code;
        return this;
    }
    public ResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <U> ResponseBuilder<U> builder(U data) {
        return new ResponseBuilder<U>().data(data);
    }

    public static <U> ResponseBuilder<U> okResponseBuilder(U data) {
        return ResponseBuilder.builder(data).status(HttpStatus.OK).code("00").message("ok");
    }


    public ResponseEntity<ResponseHolder<T>> build() {
        ResponseHolder<T> body = new ResponseHolder<>(code, message, data);
        return new ResponseEntity<>(body, headers, status);
    }
}
