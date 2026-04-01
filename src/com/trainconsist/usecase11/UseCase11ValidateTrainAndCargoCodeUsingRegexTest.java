package com.trainconsist.usecase11;

/**
 * Lightweight test harness for UC11 regex validation behavior.
 */
public class UseCase11ValidateTrainAndCargoCodeUsingRegexTest {

    public static void main(String[] args) {
        testRegex_ValidTrainID();
        testRegex_InvalidTrainIDFormat();
        testRegex_ValidCargoCode();
        testRegex_InvalidCargoCodeFormat();
        testRegex_TrainIDDigitLengthValidation();
        testRegex_CargoCodeUppercaseValidation();
        testRegex_EmptyInputHandling();
        testRegex_ExactPatternMatch();

        System.out.println("All UC11 regex tests passed.");
    }

    static void testRegex_ValidTrainID() {
        boolean isValid = UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRN-1234");
        assertTrue(isValid, "TRN-1234 should be valid");
    }

    static void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRAIN12"), "TRAIN12 should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRN12A"), "TRN12A should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("1234-TRN"), "1234-TRN should be invalid");
    }

    static void testRegex_ValidCargoCode() {
        boolean isValid = UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET-AB");
        assertTrue(isValid, "PET-AB should be valid");
    }

    static void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET-ab"), "PET-ab should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET123"), "PET123 should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("AB-PET"), "AB-PET should be invalid");
    }

    static void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRN-123"), "TRN-123 should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRN-12345"), "TRN-12345 should be invalid");
    }

    static void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET-aB"), "PET-aB should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET-Ab"), "PET-Ab should be invalid");
    }

    static void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId(""), "Empty Train ID should be invalid");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode(""), "Empty Cargo Code should be invalid");
    }

    static void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("XTRN-1234"), "Leading extra chars should fail");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidTrainId("TRN-1234X"), "Trailing extra chars should fail");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("XPET-AB"), "Leading extra chars should fail");
        assertFalse(UseCase11ValidateTrainAndCargoCodeUsingRegex.isValidCargoCode("PET-ABX"), "Trailing extra chars should fail");
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
