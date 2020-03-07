package abstraction;

import java.util.Arrays;

interface Animal {
    default void makeSound() {
        System.out.println("Making sound");
    }

    static void print() {
        System.out.println("I am an animal");
    }
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bow Bow");
    }

    public static void print(){
        System.out.println("I am a Dog");
    }


}

public class StaticDefaultDemo {
    public static void main(String[] args) {

        Animal animal1 = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("In main");
            }
        };

        animal1.makeSound();

        Animal animal = new Dog();
        animal.makeSound(); // Default method

        Animal.print(); // Animal's static method

        Dog.print(); // Dog's static method
    }
}
