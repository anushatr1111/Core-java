import java.util.Scanner;
public class EmployeePolymorphism {
    void calculateBonus() {
        System.out.println("Calculating employee bonus");
    }
}
class Developer extends EmployeePolymorphism {
    void calculateBonus() {
       int Developer_salary = 500000;
         int Developer_bonus = (int)(Developer_salary * 0.2);
          System.out.println("Developer's bonus: " + Developer_bonus);

    }
}
class Manager extends EmployeePolymorphism {
    void calculateBonus() {
        int Manager_salary = 800000;
        int Manager_bonus = (int)(Manager_salary * 0.3);
        System.out.println("Manager's bonus: " + Manager_bonus);
    }
}
class Designer extends EmployeePolymorphism {
    void calculateBonus() {
        int Designer_salary = 600000;
        int Designer_bonus = (int)(Designer_salary * 0.15);
        System.out.println("Designer's bonus: " + Designer_bonus);
    }
    public static void main(String[] args) {
        EmployeePolymorphism emp;
        emp = new Developer();
        emp.calculateBonus();
        emp = new Manager();
        emp.calculateBonus();
        emp = new Designer();
        emp.calculateBonus();
    }
}