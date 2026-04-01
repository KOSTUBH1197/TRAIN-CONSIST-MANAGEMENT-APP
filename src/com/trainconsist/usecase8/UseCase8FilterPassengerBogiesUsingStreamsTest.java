package com.trainconsist.usecase8;

import com.trainconsist.model.Bogie;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight test harness for UC8 stream filtering behavior.
 */
public class UseCase8FilterPassengerBogiesUsingStreamsTest {

    public static void main(String[] args) {
        testFilter_CapacityGreaterThanThreshold();
        testFilter_CapacityEqualToThreshold();
        testFilter_CapacityLessThanThreshold();
        testFilter_MultipleBogiesMatching();
        testFilter_NoBogiesMatching();
        testFilter_AllBogiesMatching();
        testFilter_EmptyBogieList();
        testFilter_OriginalListUnchanged();

        System.out.println("All UC8 stream-filter tests passed.");
    }

    static void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 70),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 70);

        assertEquals(1, filtered.size(), "Only one bogie should have capacity > 70");
        assertEquals("Sleeper", filtered.get(0).getName(), "Sleeper should be included");
    }

    static void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 70),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 70);

        assertEquals(0, filtered.size(), "Capacity equal to threshold should be excluded");
    }

    static void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 70);

        assertTrue(filtered.isEmpty(), "Capacities below threshold should be excluded");
    }

    static void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 60);

        assertEquals(2, filtered.size(), "Two bogies should match capacity > 60");
        assertTrue(filtered.stream().anyMatch(b -> b.getName().equals("Sleeper")), "Sleeper should be present");
        assertTrue(filtered.stream().anyMatch(b -> b.getName().equals("AC Chair")), "AC Chair should be present");
    }

    static void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24),
                new Bogie("Executive", 30)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 70);

        assertTrue(filtered.isEmpty(), "No bogies should match capacity > 70");
    }

    static void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("Super Chair", 80)
        );

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 60);

        assertEquals(3, filtered.size(), "All bogies should match capacity > 60");
    }

    static void testFilter_EmptyBogieList() {
        List<Bogie> bogies = List.of();

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(bogies, 60);

        assertTrue(filtered.isEmpty(), "Filtering an empty list should return an empty list");
    }

    static void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Sleeper", 72));
        original.add(new Bogie("AC Chair", 56));
        original.add(new Bogie("First Class", 24));

        int originalSize = original.size();
        String firstNameBefore = original.get(0).getName();

        List<Bogie> filtered = UseCase8FilterPassengerBogiesUsingStreams.filterByCapacityGreaterThan(original, 60);

        assertEquals(1, filtered.size(), "One bogie should match capacity > 60");
        assertEquals(originalSize, original.size(), "Original list size should remain unchanged");
        assertEquals(firstNameBefore, original.get(0).getName(), "Original list ordering/content should remain unchanged");
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
