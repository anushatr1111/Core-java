import java.util.*;
public class AnimalDog {
    String name;
    int age;
    void eat(){
        System.out.println(name + " is eating.");
        System.out.println(age + " years old.");
    }
}
class Dog extends AnimalDog {
    void bark() {
        System.out.println(name + " is barking.");
    }
}
class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.age = 3;
        dog.eat();
        dog.bark();
    }
}
