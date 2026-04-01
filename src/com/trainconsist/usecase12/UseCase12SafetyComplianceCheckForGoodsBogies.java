package com.trainconsist.usecase12;

import com.trainconsist.model.GoodsBogie;

import java.util.List;

/**
 * =============================================================
 * MAIN CLASS - UseCase12SafetyComplianceCheckForGoodsBogies
 * =============================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 */
public class UseCase12SafetyComplianceCheckForGoodsBogies {

    @FunctionalInterface
    public interface GoodsSafetyRule {
        boolean isCompliant(GoodsBogie bogie);
    }

    public static boolean isTrainSafetyCompliant(List<GoodsBogie> goodsBogies) {
        GoodsSafetyRule cylindricalCargoRule = bogie ->
                !bogie.getType().equalsIgnoreCase("Cylindrical")
                        || bogie.getCargo().equalsIgnoreCase("Petroleum");

        return goodsBogies.stream().allMatch(cylindricalCargoRule::isCompliant);
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");
        System.out.println("Use Case 12: Safety Compliance Check for Goods Bogies");
        System.out.println();

        List<GoodsBogie> goodsBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        System.out.println("Goods bogie assignments:");
        goodsBogies.forEach(b -> System.out.println("  " + b));

        boolean safetyCompliant = isTrainSafetyCompliant(goodsBogies);

        System.out.println();
        System.out.println("Safety compliance status: " + (safetyCompliant ? "SAFE" : "UNSAFE"));
        System.out.println("Program continues...");
    }
}
