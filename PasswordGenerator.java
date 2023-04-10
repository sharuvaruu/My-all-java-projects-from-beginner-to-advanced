import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String ALL_CHARACTERS = UPPER_CASE + LOWER_CASE + NUMBERS + SPECIAL_CHARACTERS;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUpperCase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowerCase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUpperCase, includeLowerCase, includeNumbers, includeSpecialCharacters);
        System.out.println("Generated Password: " + password);

    }

    private static String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase, boolean includeNumbers, boolean includeSpecialCharacters) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String characters = "";
        if (includeUpperCase) {
            characters += UPPER_CASE;
        }
        if (includeLowerCase) {
            characters += LOWER_CASE;
        }
        if (includeNumbers) {
            characters += NUMBERS;
        }
        if (includeSpecialCharacters) {
            characters += SPECIAL_CHARACTERS;
        }
        if (characters.isEmpty()) {
            characters = ALL_CHARACTERS; // if no character type is selected, include all characters
        }
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomCharacter = characters.charAt(randomIndex);
            sb.append(randomCharacter);
        }
        return sb.toString();
    }
} 