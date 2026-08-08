import java.util.Scanner;

public class ISBNValidator {

    static String normalize(String s) {
        s = s.trim();
        return s.substring(0, 3).toUpperCase() + s.substring(3);
    }

    static void check(String s) {
        if (s.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }

        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(s.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return;
            }

        for (int i = 3; i < 13; i++)
            if (!Character.isDigit(s.charAt(i))) {
                System.out.println("Invalid: body must contain only digits");
                return;
            }

        System.out.println("[" + s.substring(0,3) + "] YEAR: " +
                s.substring(3,7) + " | CATALOG: " + s.substring(7));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = normalize(sc.nextLine());
        check(code);
    }
}
