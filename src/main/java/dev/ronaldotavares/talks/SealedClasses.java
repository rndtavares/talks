package dev.ronaldotavares.talks;

public class SealedClasses {
    public static void main(String[] args) {
        System.out.println("Sealed Classes");
        var sealedClasses = new SealedClasses();
        sealedClasses.getType(new Persian());
    }
    String getType(Cat cat) {
        return switch (cat) {
            case Persian t -> "Persian!";
            case Siamese b -> "Siamese!";
        };
    }
}

//sealed class and implementations
sealed class Dog permits Chihuahua, Poodle {}
final class Chihuahua extends Dog {}
non-sealed class Poodle extends Dog {}

//wrong order sealed class keywords
//class sealed Frog permits GlassFrog {} // DOES NOT COMPILE
//final class GlassFrog extends Frog {}

//class not listed in permits clause cannot extend sealed class
abstract sealed class Mammal permits Wolf {}
final class Wolf extends Mammal {}
//final class Tiger extends Mammal {} // DOES NOT COMPILE

//sealed class does not compile when class listed do not extend it
//sealed class Penguin permits Emperor {}
final class Emperor {}

//sealed and final class subclass
sealed class Antelope permits Gazelle {}
final class Gazelle extends Antelope {}
//class DamaGazelle extends Gazelle {} // DOES NOT COMPILE

//sealed subclasses
sealed class Fish permits ClownFish {}
sealed class ClownFish extends Fish permits OrangeClownFish {}
final class OrangeClownFish extends ClownFish {}

//non-sealed subclasses
abstract sealed class Mammal1 permits Feline {}
non-sealed class Feline extends Mammal1 {}
class Tiger extends Feline {}
class BengalTiger extends Tiger {}

//Omitting the permits Clause
//can use permits clause inside the same file
sealed class Snake permits Cobra {}
final class Cobra extends Snake {}
//can omit permits clause inside the same file
sealed class Snake1 {}
final class Cobra1 extends Snake1 {}

//can omit permits clause in nested classes
sealed class Snake2 {
    final class Cobra2 extends Snake2 {}
}
//can also use permits clause in nested classes
//invalid syntax
//sealed class Snake3 permits Cobra3 { // DOES NOT COMPILE
//    final class Cobra3 extends Snake3 {}
//}
//valid syntax
sealed class Snake4 permits Snake4.Cobra4 {
    final class Cobra4 extends Snake4 {}
}

//sealed interface and implementations
sealed interface Swims permits Duck, Swan, Floats {}
// Classes permitted to implement sealed interface
final class Duck implements Swims {}
final class Swan implements Swims {}
// Interface permitted to extend sealed interface
non-sealed interface Floats extends Swims {}

//abstract sealed class and implementations
abstract sealed class Cat permits Persian, Siamese {}
final class Persian extends Cat {}
final class Siamese extends Cat {}
