package com.suru.students.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

public class EntityNotfoundException extends Exception {
    public EntityNotfoundException(String name, UUID id) {
        super(MessageFormat.format("{0}: {1} not found", name, id));
    }
}
