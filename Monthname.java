import java.util.Scanner;
public class Monthname {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (1-12): ");
        int month = sc.nextInt();
        int numberofDays=0;
        String monthName;
        switch (month) {
            case 1:
                monthName = "January";
                numberofDays = 31;
                break;
            case 2:
                monthName = "February";
                numberofDays = 28; // Not accounting for leap years
                break;
            case 3:
                monthName = "March";
                numberofDays = 31;
                break;
            case 4:
                monthName = "April";
                numberofDays = 30;
                break;
            case 5:
                monthName = "May";
                numberofDays = 31;
                break;
            case 6:
                monthName = "June";
                numberofDays = 30;
                break;
            case 7:
                monthName = "July";
                numberofDays = 31;
                break;
            case 8:
                monthName = "August";
                numberofDays = 31;
                break;
            case 9:
                monthName = "September";
                numberofDays = 30;
                break;
            case 10:
                monthName = "October";
                numberofDays = 31;
                break;
            case 11:
                monthName = "November";
                numberofDays = 30;
                break;
            case 12:
                monthName = "December";
                numberofDays = 31;
                break;
            default:
                monthName = "Invalid month";
        }
        System.out.println("The month is: " + monthName);
        System.out.println("Number of days: " + numberofDays);
        sc.close();
    }
}
