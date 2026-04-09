package com.trainconsist.usecase18;

/**
 * Lightweight test harness for UC18 linear search behavior.
 */
public class UseCase18LinearSearchForBogieIdTest {

    public static void main(String[] args) {
        testSearch_BogieFound();
        testSearch_BogieNotFound();
        testSearch_FirstElementMatch();
        testSearch_LastElementMatch();
        testSearch_SingleElementArray();

        System.out.println("All UC18 linear-search tests passed.");
    }

    static void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase18LinearSearchForBogieId.containsBogieId(bogieIds, "BG309");

        assertTrue(found, "Existing bogie ID should be found");
    }

    static void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase18LinearSearchForBogieId.containsBogieId(bogieIds, "BG999");

        assertFalse(found, "Missing bogie ID should return false");
    }

    static void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase18LinearSearchForBogieId.containsBogieId(bogieIds, "BG101");

        assertTrue(found, "Match at the first element should return true");
    }

    static void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase18LinearSearchForBogieId.containsBogieId(bogieIds, "BG550");

        assertTrue(found, "Match at the last element should return true");
    }

    static void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};

        boolean found = UseCase18LinearSearchForBogieId.containsBogieId(bogieIds, "BG101");

        assertTrue(found, "Single-element array should be searched correctly");
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
