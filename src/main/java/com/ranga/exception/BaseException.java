package com.ranga.exception;

/**
 * Created by RANGA on 1/24/2017.
 */
public class BaseException extends RuntimeException{

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
