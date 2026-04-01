package com.trainconsist.usecase8;

import com.trainconsist.model.Bogie;
import com.trainconsist.usecase7.UseCase7SortBogiesByCapacity;

import java.util.List;

/**
 * =====================================================
 * MAIN CLASS - UseCase8FilterPassengerBogiesUsingStreams
 * =====================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 */
public class UseCase8FilterPassengerBogiesUsingStreams {

    public static List<Bogie> filterByCapacityGreaterThan(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 8: Filter Passenger Bogies Using Streams");
        System.out.println();

        List<Bogie> passengerBogies = UseCase7SortBogiesByCapacity.createPassengerBogies();

        System.out.println("All passenger bogies:");
        passengerBogies.forEach(b -> System.out.println("  " + b));

        int threshold = 60;
        List<Bogie> highCapacityBogies = filterByCapacityGreaterThan(passengerBogies, threshold);

        System.out.println();
        System.out.println("Filtered bogies (capacity > " + threshold + "):");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("  No bogies matched the filter condition.");
        } else {
            highCapacityBogies.forEach(b -> System.out.println("  " + b));
        }

        System.out.println();
        System.out.println("Program continues...");
    }
}
