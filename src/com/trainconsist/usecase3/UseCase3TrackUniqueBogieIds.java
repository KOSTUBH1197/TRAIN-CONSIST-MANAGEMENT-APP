package com.trainconsist.usecase3;

import java.util.HashSet;
import java.util.Set;

/**
 * ==========================================
 * MAIN CLASS - UseCase3TrackUniqueBogieIds
 * ==========================================
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * This class demonstrates how duplicate bogie IDs are
 * prevented by using a Set implementation.
 *
 * At this stage, the application:
 * - Creates a HashSet for bogie IDs
 * - Adds bogie IDs, including duplicates
 * - Ignores repeated values automatically
 * - Displays only unique bogie IDs
 *
 * This use case introduces uniqueness enforcement
 * through hashing.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase3TrackUniqueBogieIds {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 3: Track Unique Bogie IDs");
        System.out.println();

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("Bogie IDs entered: BG101, BG102, BG103, BG101, BG102");
        System.out.println("Unique bogie IDs stored in system: " + bogieIds);
        System.out.println("Total unique bogie IDs: " + bogieIds.size());
        System.out.println("Program continues...");
    }
}
