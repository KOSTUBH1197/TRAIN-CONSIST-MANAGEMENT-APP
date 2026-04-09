package com.trainconsist.usecase18;

import java.util.Arrays;

/**
 * ==========================================
 * MAIN CLASS - UseCase18LinearSearchForBogieId
 * ==========================================
 *
 * Use Case 18: Linear Search for Bogie ID
 */
public class UseCase18LinearSearchForBogieId {

    public static boolean containsBogieId(String[] bogieIds, String searchKey) {
        for (String bogieId : bogieIds) {
            if (bogieId.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 18: Linear Search for Bogie ID");
        System.out.println();

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Available bogie IDs:");
        System.out.println("  " + Arrays.toString(bogieIds));
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
