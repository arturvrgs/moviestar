package utils;

public class InputValidator {
    public static boolean IsOptionString(String option) {
        while (true) {
            try {
                Integer.parseInt(option);
                return false;
            }
            catch (NumberFormatException e) {
                System.out.println("Você deve digitar uma opção válida.");
                return true;
            }
        }
    }
}
