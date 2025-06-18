package ru.sberhack2025.companyevents.common.error.exception.common;

/**
 * @author Andrey Kurnosov
 */
public class InternalServerError extends RuntimeException {
    public InternalServerError(String message) {
        super(message);
    }
}