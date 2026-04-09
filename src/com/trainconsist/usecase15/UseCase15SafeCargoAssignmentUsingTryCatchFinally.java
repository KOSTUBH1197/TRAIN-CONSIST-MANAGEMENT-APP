package com.trainconsist.usecase15;

import com.trainconsist.model.CargoSafetyException;

import java.util.ArrayList;
import java.util.List;

/**
 * ===============================================================
 * MAIN CLASS - UseCase15SafeCargoAssignmentUsingTryCatchFinally
 * ===============================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 */
public class UseCase15SafeCargoAssignmentUsingTryCatchFinally {

    /**
     * Mutable goods bogie used for runtime cargo assignment scenarios.
     */
    public static class OperationalGoodsBogie {
        private final String type;
        private String cargo;

        public OperationalGoodsBogie(String type) {
            if (type == null || type.isBlank()) {
                throw new IllegalArgumentException("Bogie type cannot be null or blank");
            }
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        private void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            String currentCargo = cargo == null ? "No Cargo Assigned" : cargo;
            return String.format("%s (%s)", type, currentCargo);
        }
    }

    /**
     * Result object used by the test harness to verify graceful handling.
     */
    public static class AssignmentResult {
        private final boolean assigned;
        private final String message;
        private final boolean finallyExecuted;

        public AssignmentResult(boolean assigned, String message, boolean finallyExecuted) {
            this.assigned = assigned;
            this.message = message;
            this.finallyExecuted = finallyExecuted;
        }

        public boolean isAssigned() {
            return assigned;
        }

        public String getMessage() {
            return message;
        }

        public boolean isFinallyExecuted() {
            return finallyExecuted;
        }
    }

    public static AssignmentResult assignCargoSafely(OperationalGoodsBogie bogie, String cargo, List<String> eventLog) {
        boolean finallyExecuted = false;
        boolean assigned = false;
        String message;

        try {
            validateCargoCompatibility(bogie, cargo);
            bogie.setCargo(cargo);

            message = "Cargo assigned successfully: " + cargo + " -> " + bogie.getType() + " bogie";
            assigned = true;
            eventLog.add(message);
        } catch (CargoSafetyException e) {
            message = "Cargo assignment failed: " + e.getMessage();
            eventLog.add(message);
        } finally {
            finallyExecuted = true;
            String completionMessage = "Assignment process completed for " + bogie.getType() + " bogie";
            eventLog.add(completionMessage);
            eventLog.add("Finally block executed.");
        }

        return new AssignmentResult(assigned, message, finallyExecuted);
    }

    public static void validateCargoCompatibility(OperationalGoodsBogie bogie, String cargo) {
        if (cargo == null || cargo.isBlank()) {
            throw new IllegalArgumentException("Cargo cannot be null or blank");
        }

        if (bogie.getType().equalsIgnoreCase("Rectangular")
                && cargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Petroleum cannot be assigned to a Rectangular bogie");
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 15: Safe Cargo Assignment Using try-catch-finally");
        System.out.println();

        List<String> eventLog = new ArrayList<>();

        OperationalGoodsBogie cylindricalBogie = new OperationalGoodsBogie("Cylindrical");
        OperationalGoodsBogie rectangularBogie = new OperationalGoodsBogie("Rectangular");
        OperationalGoodsBogie openBogie = new OperationalGoodsBogie("Open");

        System.out.println("Attempting runtime cargo assignments...");
        System.out.println();

        AssignmentResult firstResult = assignCargoSafely(cylindricalBogie, "Petroleum", eventLog);
        System.out.println(firstResult.getMessage());

        AssignmentResult secondResult = assignCargoSafely(rectangularBogie, "Petroleum", eventLog);
        System.out.println(secondResult.getMessage());

        AssignmentResult thirdResult = assignCargoSafely(openBogie, "Coal", eventLog);
        System.out.println(thirdResult.getMessage());

        System.out.println();
        System.out.println("Final bogie status:");
        System.out.println("  " + cylindricalBogie);
        System.out.println("  " + rectangularBogie);
        System.out.println("  " + openBogie);

        System.out.println();
        System.out.println("Completion log:");
        eventLog.forEach(entry -> System.out.println("  " + entry));

        System.out.println();
        System.out.println("Program continues safely after handling runtime exception.");
    }
}
