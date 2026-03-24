package com.trainconsist.usecase1;

import com.trainconsist.model.TrainConsist;

/**
 * ============================================================
 * MAIN CLASS - UseCase1InitializeTrainAndDisplayConsistSummary
 * ============================================================
 *
 * Use Case 1: Initialize Train and Display Consist Summary
 *
 * Description:
 * This class represents the entry point of the Train Consist
 * Management Application.
 *
 * At this stage, the application:
 * - Creates an empty train consist
 * - Uses a dynamic List to store bogies
 * - Displays initial bogie count
 * - Prints the current state of the train
 *
 * This use case introduces collection initialization and
 * basic program startup flow.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase1InitializeTrainAndDisplayConsistSummary {

    public static void main(String[] args) {
        // Display welcome banner.
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println();

        // Initialize the train consist with an empty dynamic collection.
        TrainConsist trainConsist = new TrainConsist();

        // Display the initial state of the consist.
        System.out.println("Train initialized successfully...");
        System.out.println("Initial bogie count: " + trainConsist.getBogieCount());
        System.out.println("Current train consist: " + trainConsist.getBogies());
        System.out.println("Program continues...");
    }
}
