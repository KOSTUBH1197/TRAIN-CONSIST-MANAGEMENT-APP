package com.trainconsist.usecase16;

import com.trainconsist.model.InvalidCapacityException;
import com.trainconsist.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight test harness for UC16 bubble sort behavior.
 */
public class UseCase16SortPassengerBogieCapacitiesUsingBubbleSortTest {

    public static void main(String[] args) throws Exception {
        testSort_CapacitiesAscendingOrder();
        testSort_AlreadySortedList();
        testSort_DuplicateCapacities();
        testSort_SingleBogieList();
        testSort_EmptyList();
        testSort_OriginalListUnchanged();

        System.out.println("All UC16 bubble-sort tests passed.");
    }

    static void testSort_CapacitiesAscendingOrder() throws Exception {
        List<PassengerBogie> bogies = List.of(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("First Class", 24),
                new PassengerBogie("AC Chair", 56),
                new PassengerBogie("Tourist", 40)
        );

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(bogies);

        assertCapacityOrder(sorted, new int[]{24, 40, 56, 72}, "Bogies should be sorted in ascending capacity order");
    }

    static void testSort_AlreadySortedList() throws Exception {
        List<PassengerBogie> bogies = List.of(
                new PassengerBogie("First Class", 24),
                new PassengerBogie("Tourist", 40),
                new PassengerBogie("AC Chair", 56)
        );

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(bogies);

        assertCapacityOrder(sorted, new int[]{24, 40, 56}, "Already sorted list should remain in ascending order");
    }

    static void testSort_DuplicateCapacities() throws Exception {
        List<PassengerBogie> bogies = List.of(
                new PassengerBogie("Sleeper A", 72),
                new PassengerBogie("Sleeper B", 72),
                new PassengerBogie("AC Chair", 56)
        );

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(bogies);

        assertCapacityOrder(sorted, new int[]{56, 72, 72}, "Duplicate capacities should be handled correctly");
    }

    static void testSort_SingleBogieList() throws Exception {
        List<PassengerBogie> bogies = List.of(
                new PassengerBogie("Sleeper", 72)
        );

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(bogies);

        assertCapacityOrder(sorted, new int[]{72}, "Single bogie list should remain unchanged");
    }

    static void testSort_EmptyList() {
        List<PassengerBogie> bogies = List.of();

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(bogies);

        assertEquals(0, sorted.size(), "Empty list should remain empty after sorting");
    }

    static void testSort_OriginalListUnchanged() throws InvalidCapacityException {
        List<PassengerBogie> original = new ArrayList<>();
        original.add(new PassengerBogie("Sleeper", 72));
        original.add(new PassengerBogie("First Class", 24));
        original.add(new PassengerBogie("AC Chair", 56));

        List<PassengerBogie> sorted = UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
                .bubbleSortByCapacityAscending(original);

        assertCapacityOrder(sorted, new int[]{24, 56, 72}, "Sorted list should be correct");
        assertCapacityOrder(original, new int[]{72, 24, 56}, "Original list should not be modified");
    }

    private static void assertCapacityOrder(List<PassengerBogie> bogies, int[] expected, String message) {
        if (bogies.size() != expected.length) {
            throw new AssertionError(message + " | expected size=" + expected.length + ", actual size=" + bogies.size());
        }

        for (int i = 0; i < expected.length; i++) {
            if (bogies.get(i).getCapacity() != expected[i]) {
                throw new AssertionError(message + " | mismatch at index " + i
                        + ", expected=" + expected[i] + ", actual=" + bogies.get(i).getCapacity());
            }
        }
    }

    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
