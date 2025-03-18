import java.util.Random;

class Utils {
    public static boolean isValidInput(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');

    }
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }


}
