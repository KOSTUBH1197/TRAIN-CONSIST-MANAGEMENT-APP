package com.trainconsist.usecase14;

import com.trainconsist.model.InvalidCapacityException;
import com.trainconsist.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================================================
 * MAIN CLASS - UseCase14HandleInvalidBogieCapacityCustomException
 * =================================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 */
public class UseCase14HandleInvalidBogieCapacityCustomException {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)");
        System.out.println();

        List<PassengerBogie> trainBogies = new ArrayList<>();

        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            trainBogies.add(sleeper);
            System.out.println("Added bogie: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("Failed to add valid bogie: " + e.getMessage());
        }

        try {
            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            trainBogies.add(invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Validation failed for invalid bogie: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Final passenger bogies in train: " + trainBogies);
        System.out.println("Program continues...");
    }
}
