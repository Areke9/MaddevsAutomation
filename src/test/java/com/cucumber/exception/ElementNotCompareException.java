package com.cucumber.exception;

public class ElementNotCompareException extends RuntimeException {
    public ElementNotCompareException(){
        super("Element does not match!");
    }
}
