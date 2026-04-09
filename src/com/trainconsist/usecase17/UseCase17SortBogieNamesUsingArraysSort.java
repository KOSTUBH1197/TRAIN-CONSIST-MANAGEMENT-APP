package com.trainconsist.usecase17;

import java.util.Arrays;

/**
 * ===============================================
 * MAIN CLASS - UseCase17SortBogieNamesUsingArraysSort
 * ===============================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 */
public class UseCase17SortBogieNamesUsingArraysSort {

    public static String[] sortBogieNames(String[] bogieNames) {
        String[] sortedNames = Arrays.copyOf(bogieNames, bogieNames.length);
        Arrays.sort(sortedNames);
        return sortedNames;
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 17: Sort Bogie Names Using Arrays.sort()");
        System.out.println();

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Bogie names before sorting:");
        System.out.println("  " + Arrays.toString(bogieNames));

        String[] sortedBogieNames = sortBogieNames(bogieNames);

        System.out.println();
        System.out.println("Bogie names after Arrays.sort():");
        System.out.println("  " + Arrays.toString(sortedBogieNames));

        System.out.println();
        System.out.println("Program continues...");
    }
}
