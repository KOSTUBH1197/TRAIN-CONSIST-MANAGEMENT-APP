package com.trainconsist.usecase19;

/**
 * Lightweight test harness for UC19 binary search behavior.
 */
public class UseCase19BinarySearchForBogieIdTest {

    public static void main(String[] args) {
        testBinarySearch_BogieFound();
        testBinarySearch_BogieNotFound();
        testBinarySearch_FirstElementMatch();
        testBinarySearch_LastElementMatch();
        testBinarySearch_SingleElementArray();
        testBinarySearch_EmptyArray();
        testBinarySearch_UnsortedInputHandled();

        System.out.println("All UC19 binary-search tests passed.");
    }

    static void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG309");

        assertTrue(found, "Existing bogie ID should be found by binary search");
    }

    static void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG999");

        assertFalse(found, "Missing bogie ID should return false");
    }

    static void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG101");

        assertTrue(found, "First element should be found correctly");
    }

    static void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG550");

        assertTrue(found, "Last element should be found correctly");
    }

    static void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG101");

        assertTrue(found, "Single-element array should be handled correctly");
    }

    static void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG101");

        assertFalse(found, "Empty array should safely return false");
    }

    static void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        boolean found = UseCase19BinarySearchForBogieId.containsBogieId(bogieIds, "BG205");

        assertTrue(found, "Unsorted input should be sorted before binary search");
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
