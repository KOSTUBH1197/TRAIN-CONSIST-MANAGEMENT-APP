package com.trainconsist.usecase20;

import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - UseCase20ExceptionHandlingDuringSearchOperations
 * =======================================================
 *
 * Use Case 20: Exception Handling During Search Operations
 */
public class UseCase20ExceptionHandlingDuringSearchOperations {

    public static boolean searchBogieId(String[] bogieIds, String searchKey) {
        validateBogieDataAvailable(bogieIds);

        for (String bogieId : bogieIds) {
            if (bogieId.equals(searchKey)) {
                return true;
            }
        }

        return false;
    }

    public static void validateBogieDataAvailable(String[] bogieIds) {
        if (bogieIds.length == 0) {
            throw new IllegalStateException("Search cannot proceed because no bogies are available in the train.");
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 20: Exception Handling During Search Operations");
        System.out.println();

        String[] bogieIds = {};
        String searchKey = "BG101";

        System.out.println("Available bogie IDs:");
        System.out.println("  " + Arrays.toString(bogieIds));
        System.out.println("Search key: " + searchKey);
        System.out.println();

        boolean found = searchBogieId(bogieIds, searchKey);

        if (found) {
            System.out.println("Result: Bogie ID " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchKey + " was not found in the consist.");
        }
    }
}
