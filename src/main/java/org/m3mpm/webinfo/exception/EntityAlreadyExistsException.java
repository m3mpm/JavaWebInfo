package org.m3mpm.webinfo.exception;

public class EntityAlreadyExistsException extends RuntimeException {

    private String entityName;

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public EntityAlreadyExistsException(String message, String entityName) {
        super(message);
        this.entityName = entityName;
    }

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getEntityName() {
        return entityName;
    }
}
