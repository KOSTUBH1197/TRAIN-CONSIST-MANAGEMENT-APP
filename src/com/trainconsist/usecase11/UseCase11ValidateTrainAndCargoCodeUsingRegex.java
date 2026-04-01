package com.trainconsist.usecase11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * =========================================================
 * MAIN CLASS - UseCase11ValidateTrainAndCargoCodeUsingRegex
 * =========================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code Using Regex
 */
public class UseCase11ValidateTrainAndCargoCodeUsingRegex {

    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 11: Regex Validation for Train ID and Cargo Code");
        System.out.println();

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean trainIdValid = isValidTrainId(trainId);
        boolean cargoCodeValid = isValidCargoCode(cargoCode);

        System.out.println("Train ID: " + trainId + " -> " + (trainIdValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (cargoCodeValid ? "Valid" : "Invalid"));

        System.out.println();
        System.out.println("Program continues...");
    }
}
