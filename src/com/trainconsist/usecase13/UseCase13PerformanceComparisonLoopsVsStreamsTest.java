package com.trainconsist.usecase13;

import com.trainconsist.model.Bogie;

import java.util.List;

/**
 * Lightweight test harness for UC13 loop vs stream comparison behavior.
 */
public class UseCase13PerformanceComparisonLoopsVsStreamsTest {

    public static void main(String[] args) {
        testLoopFilteringLogic();
        testStreamFilteringLogic();
        testLoopAndStreamResultsMatch();
        testExecutionTimeMeasurement();
        testLargeDatasetProcessing();

        System.out.println("All UC13 performance tests passed.");
    }

    static void testLoopFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithLoop(bogies, 60);

        assertEquals(1, filtered.size(), "Loop filtering should only keep capacities > 60");
        assertEquals("Sleeper", filtered.get(0).getName(), "Sleeper should remain after filtering");
    }

    static void testStreamFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        List<Bogie> filtered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithStream(bogies, 60);

        assertEquals(1, filtered.size(), "Stream filtering should only keep capacities > 60");
        assertEquals("Sleeper", filtered.get(0).getName(), "Sleeper should remain after filtering");
    }

    static void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Business", 64)
        );

        List<Bogie> loopFiltered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithLoop(bogies, 60);
        List<Bogie> streamFiltered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithStream(bogies, 60);

        assertEquals(loopFiltered.size(), streamFiltered.size(), "Loop and Stream results should have same size");
    }

    static void testExecutionTimeMeasurement() {
        long elapsed = UseCase13PerformanceComparisonLoopsVsStreams.measureExecutionNanos(() -> {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            if (sum < 0) {
                throw new IllegalStateException("Unreachable");
            }
        });

        assertTrue(elapsed > 0, "Elapsed time should be greater than zero");
    }

    static void testLargeDatasetProcessing() {
        List<Bogie> largeBogies = UseCase13PerformanceComparisonLoopsVsStreams.createBenchmarkBogies(200_000);

        List<Bogie> loopFiltered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithLoop(largeBogies, 60);
        List<Bogie> streamFiltered = UseCase13PerformanceComparisonLoopsVsStreams.filterWithStream(largeBogies, 60);

        assertTrue(!loopFiltered.isEmpty(), "Large dataset loop filtering should produce results");
        assertEquals(loopFiltered.size(), streamFiltered.size(), "Large dataset loop and stream results should match");
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
