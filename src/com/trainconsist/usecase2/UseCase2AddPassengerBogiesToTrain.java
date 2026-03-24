package com.trainconsist.usecase2;

import com.trainconsist.model.TrainConsist;

/**
 * ==================================================
 * MAIN CLASS - UseCase2AddPassengerBogiesToTrain
 * ==================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * added, removed, and checked dynamically using
 * ArrayList-based operations.
 *
 * At this stage, the application:
 * - Adds passenger bogies to the train
 * - Displays bogies in insertion order
 * - Removes one bogie from the consist
 * - Checks whether a bogie exists
 * - Prints the final list state
 *
 * This use case introduces basic CRUD operations on a
 * dynamic collection.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase2AddPassengerBogiesToTrain {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 2: Add Passenger Bogies to Train");
        System.out.println();

        TrainConsist passengerConsist = new TrainConsist();

        passengerConsist.addBogie("Sleeper");
        passengerConsist.addBogie("AC Chair");
        passengerConsist.addBogie("First Class");

        System.out.println("Passenger bogies added successfully.");
        System.out.println("Current passenger bogies: " + passengerConsist.getBogies());

        boolean removed = passengerConsist.removeBogie("AC Chair");
        System.out.println("Removed 'AC Chair': " + removed);

        boolean sleeperExists = passengerConsist.hasBogie("Sleeper");
        System.out.println("Does 'Sleeper' exist? " + sleeperExists);

        System.out.println("Final passenger bogie list: " + passengerConsist.getBogies());
        System.out.println("Program continues...");
    }
}
