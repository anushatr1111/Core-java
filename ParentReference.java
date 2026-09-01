public class ParentReference {
    void sound() {
        System.out.println("This is the parent class.");
    }

    public static void main(String[] args) {
        ParentReference a1 = new Dog();
        ParentReference a2 = new Cat();
        ParentReference a3 = new Cow();

        a1.sound();
        a2.sound();
        a3.sound();
    }
}

class Dog extends ParentReference {
    @Override
    void sound() {
        System.out.println("This is the Dog class.");
    }
}

class Cat extends ParentReference {
    @Override
    void sound() {
        System.out.println("This is the Cat class.");
    }
}

class Cow extends ParentReference {
    @Override
    void sound() {
        System.out.println("This is the Cow class.");
    }
}
