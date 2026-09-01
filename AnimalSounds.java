import java.util.Scanner;
public class AnimalSounds {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends AnimalSounds {
    void sound() {
        System.out.println("Dog barks");
    }
}
class cat extends AnimalSounds {
    void sound() {
        System.out.println("Cat meows");
    }
}
class cow extends AnimalSounds {
    void sound() {
        System.out.println("Cow moos");
    }
    public static void main(String[] args) {
        AnimalSounds a;
        a = new Dog();
        a.sound();
        a = new cat();
        a.sound();
        a = new cow();
        a.sound();
    }
}

