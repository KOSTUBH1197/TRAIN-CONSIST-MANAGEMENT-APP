package com.trainconsist.usecase15;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight test harness for UC15 runtime exception handling behavior.
 */
public class UseCase15SafeCargoAssignmentUsingTryCatchFinallyTest {

    public static void main(String[] args) {
        testCargo_SafeAssignment();
        testCargo_UnsafeAssignmentHandled();
        testCargo_CargoNotAssignedAfterFailure();
        testCargo_ProgramContinuesAfterException();
        testCargo_FinallyBlockExecution();

        System.out.println("All UC15 runtime-handling tests passed.");
    }

    static void testCargo_SafeAssignment() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Cylindrical");
        List<String> eventLog = new ArrayList<>();

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.AssignmentResult result =
                UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum", eventLog);

        assertTrue(result.isAssigned(), "Safe cargo assignment should succeed");
        assertEquals("Petroleum", bogie.getCargo(), "Cargo should be stored after safe assignment");
    }

    static void testCargo_UnsafeAssignmentHandled() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Rectangular");
        List<String> eventLog = new ArrayList<>();

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.AssignmentResult result =
                UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum", eventLog);

        assertFalse(result.isAssigned(), "Unsafe cargo assignment should be handled without crashing");
        assertTrue(result.getMessage().contains("Petroleum cannot be assigned to a Rectangular bogie"),
                "Handled error should explain the safety violation");
    }

    static void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Rectangular");
        List<String> eventLog = new ArrayList<>();

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum", eventLog);

        assertEquals(null, bogie.getCargo(), "Unsafe assignment must not store cargo in the bogie");
    }

    static void testCargo_ProgramContinuesAfterException() {
        List<String> eventLog = new ArrayList<>();

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie unsafeBogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Rectangular");
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie safeBogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Open");

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.AssignmentResult firstResult =
                UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(unsafeBogie, "Petroleum", eventLog);
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.AssignmentResult secondResult =
                UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(safeBogie, "Coal", eventLog);

        assertFalse(firstResult.isAssigned(), "First unsafe assignment should fail gracefully");
        assertTrue(secondResult.isAssigned(), "Program should continue and process later assignments");
        assertEquals("Coal", safeBogie.getCargo(), "Safe cargo should still be assigned after a handled failure");
    }

    static void testCargo_FinallyBlockExecution() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.OperationalGoodsBogie("Rectangular");
        List<String> eventLog = new ArrayList<>();

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum", eventLog);

        assertTrue(eventLog.contains("Finally block executed."),
                "Finally block should always execute and append its log entry");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
