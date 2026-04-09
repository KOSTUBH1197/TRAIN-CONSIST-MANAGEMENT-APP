package com.trainconsist.model;

/**
 * Thrown when a cargo assignment violates operational safety rules at runtime.
 */
public class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}
