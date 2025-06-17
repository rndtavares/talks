package dev.ronaldotavares.talks;

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
        System.out.println("text blocks");
        System.out.println("Which are true about this code? (2 answers)");
        var textBlock = """ 
                         Java      \s 
                         21        \
                         LTS""";
        System.out.print(textBlock);
        //A. It outputs two lines.
        //B. It outputs three lines.
        //C. It outputs four lines.
        //D. There is one line with trailing whitespace.
        //E. There are two lines with trailing whitespace.
        //F. If we indented each line five characters, it would change the output.
    }

    void patternMatching(){
        System.out.println("pattern matching");
        System.out.println("What is the output of calling printType(21)?");
        printType(21);
        System.out.println();
    }

    void printType(Object o) {
        if (o instanceof Integer version) {
            System.out.print("int");
//        } else if (o instanceof Long version || version <= 20) {
            System.out.print("long");
//        } default {
            System.out.print("unknown");
        }
    }

    void switchExpressions(){
        System.out.println("switch expressions");
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
        System.out.println("Records");
        System.out.println("Given the following record declaration, which line of code can fill in the blank and allow the code to compile?");
        var dogFood = new DogFood(10, "Pedigree");
    }

    record DogFood(int size, String brand) {
        public static int MAX_STORAGE = 100;
//        public DogFood() {
            //_______________________;
            //size = MAX_STORAGE;  //A
            //this.size = 10 //B
            //if(brand==null) super.brand = "Unknown" //C
            //throw new RuntimeException() //D
            //E. Code does not compile
//        }
    }

    void sealedClasses(){
        System.out.println("Sealed Classes");
        System.out.println("Assuming the following classes are declared as top‐level types in the same file, which classes contain compiler errors? (2 answers)");

    }

    sealed class Dog {}

//    class Poodle extends Dog {}

    non-sealed class Chihuahua extends Dog {}

//    sealed class GermanShepherd extends Chihuahua permits Silly {}

    final class Silly {}

    void virtualThreads(){
        System.out.println("Virtual Threads");
        System.out.println("Which is used to create or working with virtual threads?");
//        Thread.ofVirtualThread() //A
//        VirtualThread.of() //B
//        new VirtualThread() //C
        Thread.ofVirtual(); //D
    }
}
