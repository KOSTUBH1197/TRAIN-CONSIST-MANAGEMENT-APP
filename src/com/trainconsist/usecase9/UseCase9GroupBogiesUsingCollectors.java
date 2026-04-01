package com.trainconsist.usecase9;

import com.trainconsist.model.Bogie;
import com.trainconsist.usecase7.UseCase7SortBogiesByCapacity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ==============================================
 * MAIN CLASS - UseCase9GroupBogiesUsingCollectors
 * ==============================================
 *
 * Use Case 9: Group Bogies into Categories Using Streams
 */
public class UseCase9GroupBogiesUsingCollectors {

    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName, LinkedHashMap::new, Collectors.toList()));
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 9: Group Bogies Using Collectors.groupingBy()");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>(UseCase7SortBogiesByCapacity.createPassengerBogies());
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("All bogies (flat list):");
        bogies.forEach(b -> System.out.println("  " + b));

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        System.out.println();
        System.out.println("Grouped bogies by type:");
        groupedBogies.forEach((type, groupedList) -> {
            System.out.println("  " + type + " -> " + groupedList);
        });

        System.out.println();
        System.out.println("Program continues...");
    }
}
