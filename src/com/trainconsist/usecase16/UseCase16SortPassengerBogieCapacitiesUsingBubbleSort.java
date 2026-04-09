package com.trainconsist.usecase16;

import com.trainconsist.model.InvalidCapacityException;
import com.trainconsist.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
 * ============================================================
 *
 * Use Case 16: Sort Passenger Bogie Capacities Using Bubble Sort
 */
public class UseCase16SortPassengerBogieCapacitiesUsingBubbleSort {

    public static List<PassengerBogie> createPassengerBogies() throws InvalidCapacityException {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));
        bogies.add(new PassengerBogie("First Class", 24));
        bogies.add(new PassengerBogie("Tourist", 40));
        return bogies;
    }

    public static List<PassengerBogie> bubbleSortByCapacityAscending(List<PassengerBogie> bogies) {
        List<PassengerBogie> sortedBogies = new ArrayList<>(bogies);

        for (int i = 0; i < sortedBogies.size() - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < sortedBogies.size() - 1 - i; j++) {
                if (sortedBogies.get(j).getCapacity() > sortedBogies.get(j + 1).getCapacity()) {
                    PassengerBogie temp = sortedBogies.get(j);
                    sortedBogies.set(j, sortedBogies.get(j + 1));
                    sortedBogies.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return sortedBogies;
    }

    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 16: Sort Passenger Bogie Capacities Using Bubble Sort");
        System.out.println();

        List<PassengerBogie> bogies = createPassengerBogies();

        System.out.println("Passenger bogies before sorting:");
        bogies.forEach(bogie -> System.out.println("  " + bogie));

        List<PassengerBogie> sortedBogies = bubbleSortByCapacityAscending(bogies);

        System.out.println();
        System.out.println("Passenger bogies after bubble sort (low to high):");
        sortedBogies.forEach(bogie -> System.out.println("  " + bogie));

        System.out.println();
        System.out.println("Program continues...");
    }
}
