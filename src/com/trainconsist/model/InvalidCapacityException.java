package com.trainconsist.model;

/**
 * Thrown when a passenger bogie is created with invalid seat capacity.
 */
public class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}
