import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * PROBLEM 2 — Date Calculator
 * 
 * Demonstrates:
 * - Parsing a date from user input
 * - plusDays()
 * - minusDays()
 * - plusYears()
 */
public class DateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date: ");
        String input = sc.nextLine().trim();

        try {
            LocalDate date = LocalDate.parse(input);

            LocalDate after7Days = date.plusDays(7);
            LocalDate after30Days = date.plusDays(30);
            LocalDate before7Days = date.minusDays(7);
            LocalDate after1Year = date.plusYears(1);

            System.out.println("\nOriginal: " + date);
            System.out.println("\nAfter 7 days: " + after7Days);
            System.out.println("After 30 days: " + after30Days);
            System.out.println("Before 7 days: " + before7Days);
            System.out.println("After 1 year: " + after1Year);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter in yyyy-MM-dd format (e.g., 2026-09-09).");
        } finally {
            sc.close();
        }
    }
}
