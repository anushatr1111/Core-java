import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * PROBLEM 1 — Date Information
 * 
 * Demonstrates:
 * - LocalDate.now()
 * - DateTimeFormatter for custom formatting ("dd-MM-yyyy")
 * - Extraction of Year, Month, Day of Month, and Day of Week
 */
public class DateInformation {
    public static void main(String[] args) {
        // Get today's current date
        LocalDate today = LocalDate.now();

        // Formatter for dd-MM-yyyy format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Display date information
        System.out.println("Today's Date: " + today.format(formatter));
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());
        System.out.println("Day of Week: " + today.getDayOfWeek());
    }
}
