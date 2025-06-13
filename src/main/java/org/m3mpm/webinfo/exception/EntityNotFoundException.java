package org.m3mpm.webinfo.exception;

public class EntityNotFoundException extends RuntimeException{

    private String entityName;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, String entityName) {
        super(message);
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

}
