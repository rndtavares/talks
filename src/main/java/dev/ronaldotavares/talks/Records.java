package dev.ronaldotavares.talks;

import java.util.List;

public class Records {
    public static void main(String[] args) {
        System.out.println("Records");

        var records = new Records();
        records.creatingRecords();
        records.patternMatchingWithRecords();
        records.switchWithRecords(new Monkey(1));
        records.switchWithRecords(new Monkey(2l));
        records.switchWithRecords(new Monkey(3.0));
        records.switchWithRecords(new Monkey("Chimpanzee"));
    }

    void creatingRecords() {
        System.out.println("Creating Records");

        var dogPOJO = new DogPOJO("Rex", 5);
        var rexDog = new DogRecord("Rex","Silva", 5);
        var luluDog = new DogRecord("Lulu","Silva", 2);
        System.out.println(rexDog.name());
        System.out.println(luluDog);
    }

    void patternMatchingWithRecords() {
        System.out.println("Pattern matching with records");

        Object dogCouple = new DogCouple(
                new DogRecord("Joalin", "Maria", 0),
                new DogRecord("Pipoca", "Feliz", 0));

        if(dogCouple instanceof
                DogCouple(DogRecord(String name, int a, int c),
                          DogRecord second)) {
            System.out.println("First dog: " + name + ", age: " + a + ", counter: " + c);
            System.out.println("Second dog: " + second);
        }
    }

    void switchWithRecords(Monkey monkey) {
        System.out.println("Switch with records");
        var type = switch(monkey) {
            case Monkey(Long longNumber) -> longNumber + 1;
            case Monkey(Integer intNumber) -> intNumber + 10;
            case Monkey(Number number) -> number.intValue() + 100;
            case Monkey(Object object) -> -1;
        };
        System.out.println(type);
    }
}

//record DogRecord(String name, int age) {}
record DogRecord(String name, int age, int counter) {
    private static int COUNTER = 0;
    // Compact constructor
    public DogRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        name = name.toUpperCase();
        counter = ++COUNTER;
//        this.age = 8; // DOES NOT COMPILE
    }
    // Overloaded constructor
    public DogRecord(String firstName, String lastName, int age) {
        this("little " + firstName + " " + lastName,0, 0);
        age = 1; // NO EFFECT
    }
    @Override
    public String name() {
        return "my name is " + name;
    }
}

record DogCouple(DogRecord first, DogRecord second) {}

class DogPOJO {
    private final String name;
    private final int age;

    public DogPOJO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogPOJO dog = (DogPOJO) o;
        return age == dog.age && name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "DogPOJO[name=" + name + ", age=" + age + "]";
    }
}

record Monkey(Object data) {}
