package com.trainconsist.usecase4;

import java.util.LinkedList;

/**
 * ==============================================
 * MAIN CLASS - UseCase4MaintainOrderedBogieIds
 * ==============================================
 *
 * Use Case 4: Maintain Ordered Bogie IDs
 *
 * Description:
 * This class demonstrates how a train consist can be
 * maintained in physical sequence by using a LinkedList.
 *
 * At this stage, the application:
 * - Creates an ordered consist
 * - Adds bogies at the beginning and end
 * - Inserts a bogie in the middle
 * - Removes bogies from the head and tail
 * - Displays the final ordered train consist
 *
 * This use case introduces node-based storage and
 * efficient insertion and deletion operations.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase4MaintainOrderedBogieIds {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 4: Maintain Ordered Train Consist");
        System.out.println();

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.addFirst("Engine");
        trainConsist.addLast("Sleeper");
        trainConsist.addLast("AC");
        trainConsist.addLast("Cargo");
        trainConsist.addLast("Guard");

        System.out.println("Initial ordered train consist: " + trainConsist);

        trainConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + trainConsist);

        String removedFirst = trainConsist.removeFirst();
        String removedLast = trainConsist.removeLast();

        System.out.println("Removed first bogie: " + removedFirst);
        System.out.println("Removed last bogie: " + removedLast);
        System.out.println("Final ordered train consist: " + trainConsist);
        System.out.println("Program continues...");
    }
}
