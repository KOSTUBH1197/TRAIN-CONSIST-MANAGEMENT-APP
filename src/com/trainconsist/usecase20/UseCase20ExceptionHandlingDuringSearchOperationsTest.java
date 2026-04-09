package com.trainconsist.usecase20;

/**
 * Lightweight test harness for UC20 defensive search validation behavior.
 */
public class UseCase20ExceptionHandlingDuringSearchOperationsTest {

    public static void main(String[] args) {
        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();

        System.out.println("All UC20 search-validation tests passed.");
    }

    static void testSearch_ThrowsExceptionWhenEmpty() {
        try {
            UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(new String[]{}, "BG101");
            throw new AssertionError("Expected IllegalStateException for empty bogie data");
        } catch (IllegalStateException expected) {
            assertEquals(
                    "Search cannot proceed because no bogies are available in the train.",
                    expected.getMessage(),
                    "Exception message should explain why search is blocked"
            );
        }
    }

    static void testSearch_AllowsSearchWhenDataExists() {
        boolean found = UseCase20ExceptionHandlingDuringSearchOperations
                .searchBogieId(new String[]{"BG101", "BG205"}, "BG101");

        assertTrue(found, "Search should execute normally when bogie data exists");
    }

    static void testSearch_BogieFoundAfterValidation() {
        boolean found = UseCase20ExceptionHandlingDuringSearchOperations
                .searchBogieId(new String[]{"BG101", "BG205", "BG309"}, "BG205");

        assertTrue(found, "Existing bogie ID should be found after validation");
    }

    static void testSearch_BogieNotFoundAfterValidation() {
        boolean found = UseCase20ExceptionHandlingDuringSearchOperations
                .searchBogieId(new String[]{"BG101", "BG205", "BG309"}, "BG999");

        assertFalse(found, "Missing bogie ID should return false after validation");
    }

    static void testSearch_SingleElementValidCase() {
        boolean found = UseCase20ExceptionHandlingDuringSearchOperations
                .searchBogieId(new String[]{"BG101"}, "BG101");

        assertTrue(found, "Single bogie should be searchable after validation");
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

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
