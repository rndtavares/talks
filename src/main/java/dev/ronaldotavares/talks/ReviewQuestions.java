package dev.ronaldotavares.talks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReviewQuestions {
    public static void main(String[] args) {
        System.out.println("Review Questions");

        var reviewQuestions = new ReviewQuestions();
        reviewQuestions.textBlocks();
        reviewQuestions.patternMatching();
        reviewQuestions.switchExpressions();
        reviewQuestions.records();
        reviewQuestions.sealedClasses();
        reviewQuestions.virtualThreads();
    }

    void textBlocks(){
        System.out.println("**Text blocks");
        System.out.println("Which are true about this code? (2 answers)");
        var textBlock = """ 
                         Java      \s 
                         21        \
                         LTS""";
        System.out.println(textBlock);
    }

    void patternMatching(){
        System.out.println("**Pattern matching");
        System.out.println("What is the output of calling printType(20)?");
        printType(21);
        System.out.println();
    }

    void printType(Object o) {
        if (o instanceof Integer version && version < 20) {
            System.out.print("int" + version);
        } else if (o instanceof Long version) {
            System.out.print("long" + version);
//        } else if (o instanceof Integer version || version >= 20) {
//            System.out.print("bigger int");
        } else {
            System.out.print("unknown");
        }
    }

    void switchExpressions(){
        System.out.println("**Switch expressions");
        System.out.println("A minimum of how many lines need to be corrected before the following method will compile?");
        findJavaChampion(30);
        System.out.println();
    }

    void findJavaChampion(Integer id) {
       System.out.print(switch (id) {
//          case 10 -> {"Otávio Santana";}
//          case 20 -> {yield "Elder Moraes";};
          case 30 -> "Professor Isidro";
//          case 30 -> "Rafael Del Nero";
          default -> "Bruno Souza";
       });
    }

    void records(){
        System.out.println("**Records");
        System.out.println("Given the following record declaration, which line of code can fill in the blank and allow the code to compile?");
        var dogFood = new DogFood(10, "Pedigree");
    }

    record DogFood(int size, String brand) {
        public static int MAX_STORAGE = 100;
        public DogFood {
            //_______________________;
//            this.brand = "premier";
//            if(brand==null) super.brand = "Unknown";
//            size = MAX_STORAGE;
//            this(size, brand);
        }
    }

    void sealedClasses(){
        System.out.println("**Sealed Classes");
        System.out.println("Assuming the following classes are declared as top‐level types in the same file, which classes contain compiler errors? (2 answers)");

    }

    sealed class Dog {}

//    class Poodle extends Dog {}

    non-sealed class Chihuahua extends Dog {}

//    sealed class GermanShepherd extends Chihuahua permits Silly {}

    final class Silly {}

    void virtualThreads(){
        System.out.println("**Virtual Threads");
        System.out.println("Which APIs exist for creating or working with virtual threads? (Choose 2.)");
//        Executors.newVirtualThread();
//        Executors.newVirtualThreadExecutor();
        Executors.newVirtualThreadPerTaskExecutor();
//        new VirtualThread();
        Thread.ofVirtual();
//        Thread.ofVirtualThread();
    }
}
