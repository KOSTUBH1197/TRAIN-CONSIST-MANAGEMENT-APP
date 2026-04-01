package com.trainconsist.usecase9;

import com.trainconsist.model.Bogie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Lightweight test harness for UC9 stream grouping behavior.
 */
public class UseCase9GroupBogiesUsingCollectorsTest {

    public static void main(String[] args) {
        testGrouping_BogiesGroupedByType();
        testGrouping_MultipleBogiesInSameGroup();
        testGrouping_DifferentBogieTypes();
        testGrouping_EmptyBogieList();
        testGrouping_SingleBogieCategory();
        testGrouping_MapContainsCorrectKeys();
        testGrouping_GroupSizeValidation();
        testGrouping_OriginalListUnchanged();

        System.out.println("All UC9 grouping tests passed.");
    }

    static void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertTrue(grouped.containsKey("Sleeper"), "Sleeper key should exist");
        assertEquals(2, grouped.get("Sleeper").size(), "Sleeper group should contain 2 bogies");
    }

    static void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 56)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertEquals(1, grouped.size(), "Only one group should exist");
        assertEquals(3, grouped.get("AC Chair").size(), "AC Chair group should contain 3 bogies");
    }

    static void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertEquals(3, grouped.size(), "Three distinct groups should be created");
    }

    static void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = List.of();

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertTrue(grouped.isEmpty(), "Grouping empty list should return empty map");
    }

    static void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertEquals(1, grouped.size(), "Map should contain one key");
        assertTrue(grouped.containsKey("Sleeper"), "Sleeper key should exist");
    }

    static void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertTrue(grouped.containsKey("Sleeper"), "Sleeper key should exist");
        assertTrue(grouped.containsKey("AC Chair"), "AC Chair key should exist");
        assertTrue(grouped.containsKey("First Class"), "First Class key should exist");
    }

    static void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size(), "Sleeper group size should be 2");
        assertEquals(1, grouped.get("AC Chair").size(), "AC Chair group size should be 1");
        assertEquals(2, grouped.get("First Class").size(), "First Class group size should be 2");
    }

    static void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Sleeper", 72));
        original.add(new Bogie("AC Chair", 56));
        original.add(new Bogie("First Class", 24));

        int originalSize = original.size();
        String firstNameBefore = original.get(0).getName();

        Map<String, List<Bogie>> grouped = UseCase9GroupBogiesUsingCollectors.groupBogiesByType(original);

        assertEquals(3, grouped.size(), "Grouped map should have three keys");
        assertEquals(originalSize, original.size(), "Original list size should remain unchanged");
        assertEquals(firstNameBefore, original.get(0).getName(), "Original list order/content should remain unchanged");
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
