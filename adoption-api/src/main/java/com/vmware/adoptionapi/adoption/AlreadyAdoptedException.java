package com.vmware.adoptionapi.adoption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyAdoptedException extends RuntimeException{
    public AlreadyAdoptedException(String message) {
        super(message);
    }
}
