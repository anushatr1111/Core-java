public class EmployeeHierarchy {
    int id;
    String name;
    double salary;
    void calculateBonus() {
        double bonus = salary * 0.1;
        System.out.println("Bonus: " + bonus);
    }
    void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
class Manager extends EmployeeHierarchy {
    int teamSize;

    void calculateBonus() {
        double bonus = salary * 0.3;
        System.out.println("Manager Bonus: " + bonus);
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends EmployeeHierarchy {
    String programmingLanguage;
    void calculateBonus() {
        double bonus = salary * 0.2;
        System.out.println("Developer Bonus: " + bonus);
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}