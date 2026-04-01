package com.trainconsist.usecase7;

import com.trainconsist.model.Bogie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ===========================================
 * MAIN CLASS - UseCase7SortBogiesByCapacity
 * ===========================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 */
public class UseCase7SortBogiesByCapacity {

    public static List<Bogie> createPassengerBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        return bogies;
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 7: Sort Bogies by Capacity");
        System.out.println();

        List<Bogie> bogies = createPassengerBogies();

        System.out.println("Initial bogie list (unsorted):");
        bogies.forEach(b -> System.out.println("  " + b));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println();
        System.out.println("Bogies sorted by seating capacity (high to low):");
        bogies.forEach(b -> System.out.println("  " + b));

        System.out.println();
        System.out.println("Program continues...");
    }
}