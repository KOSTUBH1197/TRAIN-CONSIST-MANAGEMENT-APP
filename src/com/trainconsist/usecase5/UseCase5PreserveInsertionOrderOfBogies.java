package com.trainconsist.usecase5;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ==========================================================
 * MAIN CLASS - UseCase5PreserveInsertionOrderOfBogies
 * ==========================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class demonstrates how to maintain the physical
 * attachment order of bogies while preventing duplicates
 * by using a LinkedHashSet.
 *
 * At this stage, the application:
 * - Creates a train formation using LinkedHashSet
 * - Adds bogies in attachment order
 * - Ignores duplicate attachment automatically
 * - Displays the final ordered formation
 *
 * This use case introduces ordered uniqueness in train
 * composition.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase5PreserveInsertionOrderOfBogies {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 5: Preserve Insertion Order of Bogies");
        System.out.println();

        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("Bogies attached: Engine, Sleeper, Cargo, Guard, Sleeper");
        System.out.println("Final formation in insertion order: " + trainFormation);
        System.out.println("Total unique bogies in formation: " + trainFormation.size());
        System.out.println("Program continues...");
    }
}
