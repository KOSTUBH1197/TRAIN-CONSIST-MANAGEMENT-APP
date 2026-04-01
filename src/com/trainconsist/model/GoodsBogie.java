package com.trainconsist.model;

/**
 * Represents a goods bogie with a physical type and assigned cargo.
 */
public class GoodsBogie {
    private final String type;
    private final String cargo;

    public GoodsBogie(String type, String cargo) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Bogie type cannot be null or blank");
        }
        if (cargo == null || cargo.isBlank()) {
            throw new IllegalArgumentException("Cargo cannot be null or blank");
        }
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", type, cargo);
    }
}
