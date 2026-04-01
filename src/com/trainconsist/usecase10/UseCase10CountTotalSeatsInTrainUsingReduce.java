package com.trainconsist.usecase10;

import com.trainconsist.model.Bogie;
import com.trainconsist.usecase7.UseCase7SortBogiesByCapacity;

import java.util.List;

/**
 * ==========================================================
 * MAIN CLASS - UseCase10CountTotalSeatsInTrainUsingReduce
 * ==========================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 */
public class UseCase10CountTotalSeatsInTrainUsingReduce {

    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 10: Count Total Seats in Train (reduce)");
        System.out.println();

        List<Bogie> bogies = UseCase7SortBogiesByCapacity.createPassengerBogies();

        System.out.println("Passenger bogies:");
        bogies.forEach(b -> System.out.println("  " + b));

        int totalSeats = calculateTotalSeats(bogies);

        System.out.println();
        System.out.println("Total seating capacity of train: " + totalSeats);
        System.out.println("Program continues...");
    }
}
