package com.vmware.adoptionapi.adoption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchPetException extends RuntimeException{
    public NoSuchPetException(String message) {
        super(message);
    }
}
