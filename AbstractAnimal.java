abstract class Animal {
    abstract void makeSound();
}
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}
class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("Moo");
    }
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Cow();
        
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}