import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * PROBLEM 3 — Birthday Calculator 🎂
 * 
 * Demonstrates:
 * - Parsing a birthday (LocalDate.parse)
 * - Extracting Year, Month, and Day
 * - Comparing dates with isBefore, isAfter, isEqual
 * - Determining the next occurrence of a birthday
 * - Handling leap years (e.g. Feb 29 birthdays)
 */
public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter birthday: ");
        String input = sc.nextLine().trim();

        try {
            LocalDate birthday = LocalDate.parse(input);
            LocalDate today = LocalDate.now();

            int birthYear = birthday.getYear();
            String birthMonth = birthday.getMonth().name();
            int birthDay = birthday.getDayOfMonth();

            // Calculate this year's birthday occurrence (safely accounting for leap years)
            int currentYear = today.getYear();
            LocalDate thisYearBirthday;
            if (birthday.getMonthValue() == 2 && birthday.getDayOfMonth() == 29 && !Year.isLeap(currentYear)) {
                thisYearBirthday = LocalDate.of(currentYear, 2, 28);
            } else {
                thisYearBirthday = LocalDate.of(currentYear, birthday.getMonth(), birthday.getDayOfMonth());
            }

            // Determine if birthday has passed or is upcoming
            LocalDate nextBirthday;
            String status;

            if (thisYearBirthday.isBefore(today)) {
                status = "Birthday has already passed for this year (before today).";
                int nextYear = currentYear + 1;
                if (birthday.getMonthValue() == 2 && birthday.getDayOfMonth() == 29 && !Year.isLeap(nextYear)) {
                    nextBirthday = LocalDate.of(nextYear, 2, 28);
                } else {
                    nextBirthday = LocalDate.of(nextYear, birthday.getMonth(), birthday.getDayOfMonth());
                }
            } else if (thisYearBirthday.isAfter(today)) {
                status = "Birthday is upcoming later this year (after today).";
                nextBirthday = thisYearBirthday;
            } else {
                status = "🎉 Today is your birthday! Happy Birthday! 🎂";
                nextBirthday = thisYearBirthday;
            }

            // Output according to specification
            System.out.println("\nBirthday: " + birthday.format(displayFormatter));
            System.out.println("Year: " + birthYear);
            System.out.println("Month: " + birthMonth);
            System.out.println("Day: " + birthDay);
            System.out.println("Status: " + status);
            System.out.println("\nNext Birthday: " + nextBirthday.format(displayFormatter));

            // Extra helpful insight: days until next birthday
            long daysUntil = ChronoUnit.DAYS.between(today, nextBirthday);
            if (daysUntil > 0) {
                System.out.println("Days until next birthday: " + daysUntil + " days");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter in yyyy-MM-dd format (e.g., 2002-05-10).");
        } finally {
            sc.close();
        }
    }
}
