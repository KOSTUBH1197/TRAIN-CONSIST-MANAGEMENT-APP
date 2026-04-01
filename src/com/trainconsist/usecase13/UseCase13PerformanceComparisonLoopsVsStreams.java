package com.trainconsist.usecase13;

import com.trainconsist.model.Bogie;
import com.trainconsist.usecase7.UseCase7SortBogiesByCapacity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * =========================================================
 * MAIN CLASS - UseCase13PerformanceComparisonLoopsVsStreams
 * =========================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 */
public class UseCase13PerformanceComparisonLoopsVsStreams {

    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                result.add(bogie);
            }
        }
        return result;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();
    }

    public static long measureExecutionNanos(Runnable operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static List<Bogie> createBenchmarkBogies(int size) {
        List<Bogie> baseBogies = UseCase7SortBogiesByCapacity.createPassengerBogies();
        List<Bogie> benchmarkBogies = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Bogie template = baseBogies.get(i % baseBogies.size());
            benchmarkBogies.add(new Bogie(template.getName(), template.getCapacity()));
        }

        return benchmarkBogies;
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 13: Performance Comparison (Loops vs Streams)");
        System.out.println();

        List<Bogie> bogies = createBenchmarkBogies(100_000);
        int threshold = 60;

        AtomicReference<List<Bogie>> loopResult = new AtomicReference<>();
        AtomicReference<List<Bogie>> streamResult = new AtomicReference<>();

        long loopTime = measureExecutionNanos(() -> loopResult.set(filterWithLoop(bogies, threshold)));
        long streamTime = measureExecutionNanos(() -> streamResult.set(filterWithStream(bogies, threshold)));

        System.out.println("Dataset size: " + bogies.size());
        System.out.println("Threshold: capacity > " + threshold);
        System.out.println("Loop filtered bogies: " + loopResult.get().size());
        System.out.println("Stream filtered bogies: " + streamResult.get().size());
        System.out.println();
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);
        System.out.println();
        System.out.println("Program continues...");
    }
}
