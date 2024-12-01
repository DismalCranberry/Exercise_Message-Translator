import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Send: ");
    int n = scanner.nextInt();
    scanner.nextLine();  // Consume the newline character

    for (int i = 0; i < n; i++) {
        String s = scanner.nextLine();
        String command;
        String string;

        String pattern = "!([A-Z][a-z]{2,})!:\\[([A-Za-z]{8,})]";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(s);

        if (matcher.matches()) {
            command = matcher.group(1);
            string = matcher.group(2);
            String translatedString = translateString(string);
            System.out.println(STR."\{command}: \{translatedString}");
        } else {
            System.out.println("The message is invalid");
        }
    }
    scanner.close();
}

public static String translateString(String s) {
    StringBuilder translatedString = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        translatedString.append((int) s.charAt(i));
        if (i < s.length() - 1) {
            translatedString.append(" ");
        }
    }
    return translatedString.toString();
}
