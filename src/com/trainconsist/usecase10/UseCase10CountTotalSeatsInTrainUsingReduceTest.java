package com.trainconsist.usecase10;

import com.trainconsist.model.Bogie;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight test harness for UC10 map + reduce aggregation behavior.
 */
public class UseCase10CountTotalSeatsInTrainUsingReduceTest {

    public static void main(String[] args) {
        testReduce_TotalSeatCalculation();
        testReduce_MultipleBogiesAggregation();
        testReduce_SingleBogieCapacity();
        testReduce_EmptyBogieList();
        testReduce_CorrectCapacityExtraction();
        testReduce_AllBogiesIncluded();
        testReduce_OriginalListUnchanged();

        System.out.println("All UC10 reduce tests passed.");
    }

    static void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(152, total, "Total should equal sum of all capacities");
    }

    static void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(224, total, "All bogie capacities should be aggregated");
    }

    static void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 72));

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(72, total, "Single bogie capacity should be returned as total");
    }

    static void testReduce_EmptyBogieList() {
        List<Bogie> bogies = List.of();

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(0, total, "Empty list should return identity value 0");
    }

    static void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24),
                new Bogie("Executive", 30)
        );

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(54, total, "map() should extract exact capacity values before reduce");
    }

    static void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Tourist", 40)
        );

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(bogies);

        assertEquals(192, total, "Result should include every bogie in collection");
    }

    static void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Sleeper", 72));
        original.add(new Bogie("AC Chair", 56));
        original.add(new Bogie("First Class", 24));

        int originalSize = original.size();
        String firstNameBefore = original.get(0).getName();

        int total = UseCase10CountTotalSeatsInTrainUsingReduce.calculateTotalSeats(original);

        assertEquals(152, total, "Total should match expected sum");
        assertEquals(originalSize, original.size(), "Original list size should remain unchanged");
        assertEquals(firstNameBefore, original.get(0).getName(), "Original list content/order should remain unchanged");
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
