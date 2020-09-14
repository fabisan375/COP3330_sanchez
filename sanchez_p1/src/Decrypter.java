public class Decrypter {
    public static String decrypt(String valueAsString) {

        int valueAsInt = Integer.parseInt(valueAsString);

        int fourthDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int thirdDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int secondDigit = valueAsInt % 10;
        valueAsInt = valueAsInt / 10;
        int firstDigit = valueAsInt;

        fourthDigit = (fourthDigit + 3) % 10;
        thirdDigit = (thirdDigit + 3) % 10;
        secondDigit = (secondDigit + 3) % 10;
        firstDigit = (firstDigit + 3) % 10;

        String decryptedValue = Integer.toString(thirdDigit) + Integer.toString(fourthDigit) + Integer.toString(firstDigit) + Integer.toString(secondDigit);
        return decryptedValue;
    }
}