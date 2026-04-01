package com.trainconsist.usecase14;

import com.trainconsist.model.InvalidCapacityException;
import com.trainconsist.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight test harness for UC14 custom exception behavior.
 */
public class UseCase14HandleInvalidBogieCapacityCustomExceptionTest {

    public static void main(String[] args) throws Exception {
        testException_ValidCapacityCreation();
        testException_NegativeCapacityThrowsException();
        testException_ZeroCapacityThrowsException();
        testException_ExceptionMessageValidation();
        testException_ObjectIntegrityAfterCreation();
        testException_MultipleValidBogiesCreation();

        System.out.println("All UC14 custom-exception tests passed.");
    }

    static void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertTrue(bogie != null, "Valid bogie should be created successfully");
    }

    static void testException_NegativeCapacityThrowsException() {
        try {
            new PassengerBogie("Sleeper", -10);
            throw new AssertionError("Expected InvalidCapacityException for negative capacity");
        } catch (InvalidCapacityException expected) {
            assertTrue(true, "Negative capacity correctly throws InvalidCapacityException");
        }
    }

    static void testException_ZeroCapacityThrowsException() {
        try {
            new PassengerBogie("AC Chair", 0);
            throw new AssertionError("Expected InvalidCapacityException for zero capacity");
        } catch (InvalidCapacityException expected) {
            assertTrue(true, "Zero capacity correctly throws InvalidCapacityException");
        }
    }

    static void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("First Class", 0);
            throw new AssertionError("Expected InvalidCapacityException for invalid capacity");
        } catch (InvalidCapacityException expected) {
            assertEquals("Capacity must be greater than zero", expected.getMessage(), "Exception message should match");
        }
    }

    static void testException_ObjectIntegrityAfterCreation() throws Exception {
        PassengerBogie bogie = new PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.getType(), "Type should match constructor value");
        assertEquals(24, bogie.getCapacity(), "Capacity should match constructor value");
    }

    static void testException_MultipleValidBogiesCreation() throws Exception {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));
        bogies.add(new PassengerBogie("First Class", 24));

        assertEquals(3, bogies.size(), "All valid bogies should be created and added");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
