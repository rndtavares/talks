package dev.ronaldotavares.talks;

public class SwitchExpressions {
    public static void main(String[] args) {
        System.out.println("Switch Expressions");

        var switchExpressions = new SwitchExpressions();

        System.out.println(switchExpressions.getSeasonBad(0));
        System.out.println(switchExpressions.getSeasonBetter(2));
        System.out.println(switchExpressions.getSeasonBest(4));
        switchExpressions.definingSwitchExpression();
        switchExpressions.acceptableValues();
        switchExpressions.workingWithSwitchExpressions();
        handlingANullCase();
    }

    String getSeasonBad(int type) {
        System.out.println("if else example");
        String season;
        if(type == 0)
            season = "Spring";
        else if(type == 1)
            season = "Summer";
        else if(type == 2 || type == 3)
            season = "Fall or Winter";
        else
            season = "Unknown";
        return season;
    }

    String getSeasonBetter(int type) {
        System.out.println("Switch statement example");
        String season;
        switch (type) {
            case  0:
                season = "Spring";
                break;
            case  1:
                season = "Summer";
                break;
            case  2, 3:
                season = "Fall or Winter";
                break;
            default:
                season = "Unknown";
        }
        return season;
    }

    String getSeasonBest(int type) {
        System.out.println("Switch expression example");
        return switch (type)  {
            case  0      -> "Spring";
            case  1      -> "Summer";
            case  2, 3   -> "Fall or Winter";
            default      -> "Unknown";
        };
    }

    void definingSwitchExpression() {
        System.out.println("Defining a switch expression");
//        int type = 0;

        System.out.println("needs ; at the end of each statement");
//         var result = switch (type)  { // ;
//             case  0       -> "Spring"
//             case  1, 2, 3 -> "Summer, Fall or Winter";
//             default       -> "Unknown";
//         }

        System.out.println("needs () between the variable to be tested");
//        var result = switch type  { // ()
//            case  0       -> "Spring";
//            default       -> "Unknown";
//        };

        System.out.println("always needs {} to start and end the switch expression");
//        var result = switch (type) // {}
//            case 0 -> "Spring";

    }

    void acceptableValues() {
        feedAnimals();
        cleanFishTank(1);
        shouldGetACoat(Season.SPRING);
    }

    void feedAnimals() {
        System.out.println("case needs to be resolved at compile time");
        int numberOfAnimals = 3;
        var food = switch (numberOfAnimals)  {
            case  2 + 1             -> "Meat";
//            case  getSeasonBest(2)  -> "Soup";
            default      -> "Unknown";
        };
        System.out.println("Feeding animals with: " + food);
    }

    enum Season { SPRING, SUMMER, FALL, WINTER }

    void cleanFishTank(int dirty) {
        System.out.println("type need to be compatible");
        var result = switch (dirty) {
            // case "Very" -> "1 hour";  // DOES NOT COMPILE
            default     -> "45 minute";
        };
        System.out.println(result);
    }

    boolean shouldGetACoat(Season s) {
        System.out.println("can use enums");
        return switch (s) {
            case SPRING -> false;
            case Season.SUMMER -> false;
            case FALL -> true;
            case Season.WINTER -> true;
        };
    }

    void workingWithSwitchExpressions() {
        exhaustive();
        getWeatherCoveredAll(Season.SPRING);
        usingYieldStatement();
        usingPatternMatching();
        incorrectType();
    }

    void exhaustive() {
        System.out.println("Need to cover all possibilities");
//        String type = "z";
//        Integer letterNumber = switch (type) { // DOES NOT COMPILE
//            case "a" -> 1;
//            case "b" -> 2;
//        };

//        Season season = Season.WINTER;
//        var result = switch (season) {  // DOES NOT COMPILE
//            case WINTER -> "Cold";
//            case SPRING -> "Rainy";
//            case SUMMER -> "Hot";
//        };
//        System.out.println(result);
     }

    void getWeatherCoveredAll(Season value) {
        System.out.println("no need Default when all possibilities are covered");
        var result = switch (value) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL   -> "Warm";
            default     -> throw new RuntimeException("Unsupported Season");
        };
        System.out.println(result);
    }

    void usingYieldStatement() {
        System.out.println("Using yield statement in switch expressions");
        int dog = 5;
        int length = 12;
        var name = switch (dog) {
            case 1 -> "Chihuahua";
            case 2 -> { yield "Pomeranian"; }
            case 3 -> {
                if (length> 10) yield "Poodle";
                else yield "Beagle";
            }
            case 4 -> {
                throw new RuntimeException("Unsupported value");
            }
            default -> "Labrador Retriever";
        };
    }

    void semicolonsInSwitchExpression(){
        System.out.println("Semicolons in switch expressions");
        // int dog = 1;
        // var name = switch (dog) {
        // case 1  -> "Chihuahua"           // DOES NOT COMPILE (missing semicolon)
        // case 2  -> { yield "Poodle"; };  // DOES NOT COMPILE (extra semicolon)
        // default -> "Beagle"; }  // DOES NOT COMPILE (missing semicolon)
        // }
    }

    void usingPatternMatching() {
        printDetails(2);
        getTrainer(8);
    }

    void printDetails(Number height) {
        System.out.println("Using pattern matching in switch expressions");
        String message = switch (height) {
            case Integer i -> "Rounded: " + i;
            case Double d  -> "Precise: " + d;
            case Number n  -> "Unknown: " + n;
        };
        System.out.println(message);
    }

    String getTrainer(Number height) {
        System.out.println("Using pattern matching and when in switch expressions");
        return switch (height) {
            case Integer i when i > 10 -> "John";
            case Integer i -> "Daniel";
            case Double num when num <= 15.5 -> "Peter";
            case Double num -> "Kelly";
            case Number num -> "Ralph";
        };
    }

    private static void incorrectType() {
        System.out.println("Incorrect type in switch expression");
        Number dog = 10;
        String name = switch (dog) {
            case Integer small -> "Chihuahua";
            case Number big   -> "Labrador Retriever";
            // case String s           -> "Poodle";  // DOES NOT COMPILE
        };
    }

    void newGetTrainer(Number animal) {
        System.out.println("The order of the cases matters in switch expressions");
//        return switch (animal) {
//            case Integer i             -> "Daniel";
//            case Integer i when i > 10 -> "John"; // DOES NOT COMPILE
//        };
    }

    private static void handlingANullCase() {
        System.out.println("Handling a null case in switch expressions");
        String dog = null;
        // System.out.println(switch (dog) {
        // case "Chihuahua" -> "Hello!";
        // case "Poodle"    -> "Hello again!";
        // default          -> "Goodbye";
        // }); // NullPointerException

        if (dog == null) {
            System.out.println("What type of dog are you?");
        } else {
            System.out.println(switch (dog) {
                case "Chihuahua" -> "Hello!";
                case "Poodle"    -> "Hello again!";
                default          -> "Goodbye";
            });
        }

        System.out.println(switch (dog) {
            case "Chihuahua" -> "Hello!";
            case "Poodle"    -> "Hello again!";
            case null        -> "What type of dog are you?";
            default          -> "Goodbye";
        });

//         switch (dog) {  // DOES NOT COMPILE
//            case "Chihuahua": System.out.println("Hello!");
//            case "Poodle":  System.out.println("Hello again!");
//            case null:        System.out.println("What type of dog are you?");
//         }

        System.out.println(switch (dog) {
            case String s when "Chihuahua".equals(s) -> "Hello!";
            case null -> "No good";
            case String s when "Poodle".equals(s) -> "Hello again!";
            default -> "Goodbye";
        });

//         System.out.println(switch (dog) {
//            case String s when "Chihuahua".equals(s) -> "Hello!";
//            case String s when "Poodle".equals(s) -> "Hello again!";
//            default -> "Goodbye";
//             case null -> "No good";  // DOES NOT COMPILE
//         });
    }
}