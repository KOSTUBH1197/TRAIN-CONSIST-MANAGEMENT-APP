package com.trainconsist.usecase19;

import java.util.Arrays;

/**
 * ==========================================
 * MAIN CLASS - UseCase19BinarySearchForBogieId
 * ==========================================
 *
 * Use Case 19: Binary Search for Bogie ID
 */
public class UseCase19BinarySearchForBogieId {

    public static String[] sortBogieIds(String[] bogieIds) {
        String[] sortedIds = Arrays.copyOf(bogieIds, bogieIds.length);
        Arrays.sort(sortedIds);
        return sortedIds;
    }

    public static boolean containsBogieId(String[] bogieIds, String searchKey) {
        String[] sortedIds = sortBogieIds(bogieIds);

        int low = 0;
        int high = sortedIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(sortedIds[mid]);

            if (comparison == 0) {
                return true;
            }

            if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 19: Binary Search for Bogie ID");
        System.out.println();

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchKey = "BG309";
        String[] sortedBogieIds = sortBogieIds(bogieIds);

        System.out.println("Original bogie IDs:");
        System.out.println("  " + Arrays.toString(bogieIds));
        System.out.println("Sorted bogie IDs:");
        System.out.println("  " + Arrays.toString(sortedBogieIds));
        System.out.println("Search key: " + searchKey);

        boolean found = containsBogieId(bogieIds, searchKey);

        System.out.println();
        if (found) {
            System.out.println("Result: Bogie ID " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchKey + " was not found in the consist.");
        }

        System.out.println();
        System.out.println("Program continues...");
    }
}
