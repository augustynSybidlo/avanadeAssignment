package service;

public class CSValidator {

    public boolean validateArray(String[] array, int expectedLength) {
        return array.length == expectedLength;
    }

    public boolean validateName(String name) {
        // At this moment longest name in Guiness
        // Book have 81 chars, however you have to add last name.
        return name.length() > 1 && name.length() < 100;
    }

    public boolean validateAge(String age) {
        return age.matches("[0-9]+") && age.length() > 0;
    }
}
