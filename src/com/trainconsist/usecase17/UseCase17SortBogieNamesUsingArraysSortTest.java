package com.trainconsist.usecase17;

/**
 * Lightweight test harness for UC17 Arrays.sort() behavior.
 */
public class UseCase17SortBogieNamesUsingArraysSortTest {

    public static void main(String[] args) {
        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();

        System.out.println("All UC17 Arrays.sort() tests passed.");
    }

    static void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        String[] sorted = UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(bogieNames);

        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"},
                sorted,
                "Bogie names should be sorted alphabetically"
        );
    }

    static void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};

        String[] sorted = UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(bogieNames);

        assertArrayEquals(
                new String[]{"AC Chair", "General", "Luxury", "Sleeper"},
                sorted,
                "Unsorted bogie names should be rearranged alphabetically"
        );
    }

    static void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};

        String[] sorted = UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(bogieNames);

        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General"},
                sorted,
                "Already sorted bogie names should remain unchanged"
        );
    }

    static void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};

        String[] sorted = UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(bogieNames);

        assertArrayEquals(
                new String[]{"AC Chair", "General", "Sleeper", "Sleeper"},
                sorted,
                "Duplicate bogie names should be preserved in sorted order"
        );
    }

    static void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};

        String[] sorted = UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(bogieNames);

        assertArrayEquals(
                new String[]{"Sleeper"},
                sorted,
                "Single-element array should remain unchanged"
        );
    }

    private static void assertArrayEquals(String[] expected, String[] actual, String message) {
        if (expected.length != actual.length) {
            throw new AssertionError(message + " | expected length=" + expected.length + ", actual length=" + actual.length);
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                throw new AssertionError(message + " | mismatch at index " + i
                        + ", expected=" + expected[i] + ", actual=" + actual[i]);
            }
        }
    }
}
