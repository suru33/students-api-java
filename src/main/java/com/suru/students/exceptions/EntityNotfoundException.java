package com.suru.students.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;
import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotfoundException extends Exception {
    public EntityNotfoundException(String name, UUID id) {
        super(MessageFormat.format("{0}: {1} not found", name, id));
    }
}
