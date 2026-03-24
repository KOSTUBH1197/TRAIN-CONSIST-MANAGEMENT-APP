package com.trainconsist.usecase6;

import java.util.HashMap;
import java.util.Map;

/**
 * =========================================
 * MAIN CLASS - UseCase6MapBogieToCapacity
 * =========================================
 *
 * Use Case 6: Map Bogie to Capacity
 *
 * Description:
 * This class demonstrates how a bogie can be
 * associated with its seating or load capacity
 * by using a HashMap.
 *
 * At this stage, the application:
 * - Creates a bogie-capacity mapping
 * - Stores bogie names as keys
 * - Stores capacity values as map values
 * - Iterates through the mapping using entrySet()
 * - Displays each bogie with its capacity
 *
 * This use case introduces key-value data modeling.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase6MapBogieToCapacity {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 6: Map Bogie to Capacity");
        System.out.println();

        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);

        System.out.println("Bogie capacity details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Program continues...");
    }
}
