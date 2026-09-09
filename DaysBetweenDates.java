import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * PROBLEM 4 — Days Between Two Dates 🔥
 * 
 * Demonstrates:
 * - ChronoUnit.DAYS.between()
 * - Calculating date intervals
 */
public class DaysBetweenDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter start date: ");
            String startInput = sc.nextLine().trim();

            System.out.print("Enter end date: ");
            String endInput = sc.nextLine().trim();

            LocalDate startDate = LocalDate.parse(startInput);
            LocalDate endDate = LocalDate.parse(endInput);

            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

            System.out.println("\nDays between dates: " + daysBetween);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter dates in yyyy-MM-dd format (e.g., 2026-09-01).");
        } finally {
            sc.close();
        }
    }
}
