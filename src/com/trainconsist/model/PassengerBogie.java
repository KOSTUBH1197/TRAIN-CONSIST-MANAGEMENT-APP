package com.trainconsist.model;

/**
 * Represents a passenger bogie with validated seating capacity.
 */
public class PassengerBogie {
    private final String type;
    private final int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Bogie type cannot be null or blank");
        }
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("%s (%d seats)", type, capacity);
    }
}
