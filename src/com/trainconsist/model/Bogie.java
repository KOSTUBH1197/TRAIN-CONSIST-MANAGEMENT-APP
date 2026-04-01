package com.trainconsist.model;

/**
 * Represents a passenger bogie in the train consist.
 */
public class Bogie {
    private final String name;
    private final int capacity;

    public Bogie(String name, int capacity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Bogie name cannot be null or blank");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Bogie capacity cannot be negative");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("%s (%d seats)", name, capacity);
    }
}