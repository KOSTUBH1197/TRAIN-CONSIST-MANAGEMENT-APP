package com.trainconsist.usecase12;

import com.trainconsist.model.GoodsBogie;

import java.util.List;

/**
 * Lightweight test harness for UC12 stream safety validation behavior.
 */
public class UseCase12SafetyComplianceCheckForGoodsBogiesTest {

    public static void main(String[] args) {
        testSafety_AllBogiesValid();
        testSafety_CylindricalWithInvalidCargo();
        testSafety_NonCylindricalBogiesAllowed();
        testSafety_MixedBogiesWithViolation();
        testSafety_EmptyBogieList();

        System.out.println("All UC12 safety tests passed.");
    }

    static void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        boolean compliant = UseCase12SafetyComplianceCheckForGoodsBogies.isTrainSafetyCompliant(bogies);

        assertTrue(compliant, "All valid assignments should return true");
    }

    static void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        boolean compliant = UseCase12SafetyComplianceCheckForGoodsBogies.isTrainSafetyCompliant(bogies);

        assertFalse(compliant, "Cylindrical with non-petroleum cargo should return false");
    }

    static void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Cement")
        );

        boolean compliant = UseCase12SafetyComplianceCheckForGoodsBogies.isTrainSafetyCompliant(bogies);

        assertTrue(compliant, "Non-cylindrical bogies should allow any cargo");
    }

    static void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Cylindrical", "Grain")
        );

        boolean compliant = UseCase12SafetyComplianceCheckForGoodsBogies.isTrainSafetyCompliant(bogies);

        assertFalse(compliant, "Any one rule violation should make the whole train unsafe");
    }

    static void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = List.of();

        boolean compliant = UseCase12SafetyComplianceCheckForGoodsBogies.isTrainSafetyCompliant(bogies);

        assertTrue(compliant, "Empty list should be compliant because no violations exist");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }
}
