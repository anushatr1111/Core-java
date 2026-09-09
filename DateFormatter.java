import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * PROBLEM 5 — Date Formatter
 * 
 * Demonstrates:
 * - DateTimeFormatter with custom patterns:
 *   - Format 1: dd-MM-yyyy
 *   - Format 2: dd/MM/yyyy
 *   - Format 3: dd MMMM yyyy
 *   - Format 4: EEEE, dd MMMM yyyy
 */
public class DateFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date: ");
        String input = sc.nextLine().trim();

        try {
            LocalDate date = LocalDate.parse(input);

            // Formatters
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter format3 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");

            System.out.println("\n### Format 1");
            System.out.println(date.format(format1));

            System.out.println("\n### Format 2");
            System.out.println(date.format(format2));

            System.out.println("\n### Format 3");
            System.out.println(date.format(format3));

            System.out.println("\n### Format 4");
            System.out.println(date.format(format4));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter date in yyyy-MM-dd format (e.g., 2026-09-09).");
        } finally {
            sc.close();
        }
    }
}
