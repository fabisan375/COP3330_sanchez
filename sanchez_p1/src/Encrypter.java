public class Encrypter {
    public static String encrypt(String valueAsString) {

        int valueAsInt = Integer.parseInt(valueAsString);

        int fourthDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int thirdDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int secondDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int firstDigit = valueAsInt;

        fourthDigit = (fourthDigit + 7) % 10;
        thirdDigit = (thirdDigit + 7) % 10;
        secondDigit = (secondDigit + 7) % 10;
        firstDigit = (firstDigit + 7) % 10;

        String encryptedValue = Integer.toString(thirdDigit) + Integer.toString(fourthDigit) + Integer.toString(firstDigit) + Integer.toString(secondDigit);
        return encryptedValue;
    }
}
