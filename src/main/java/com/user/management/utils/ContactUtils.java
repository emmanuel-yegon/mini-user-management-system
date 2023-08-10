package com.user.management.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ContactUtils {

    public ContactUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }
}
