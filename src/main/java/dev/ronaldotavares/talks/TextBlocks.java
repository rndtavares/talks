package dev.ronaldotavares.talks;

public class TextBlocks {

    public static void main(String[] args) {
        System.out.println("Text Blocks");

        var textBlocks = new TextBlocks();
        textBlocks.before();
        textBlocks.after();
        textBlocks.complexTextBlock();
    }

    void before(){
        System.out.println("Before text blocks:");

        var textBlock = "    Java 30y \"let's celebrate\":\n" +
                "        - Dominando o Seu Java com Propósito\n" +
                "          Ronaldo Tavares\n";

        System.out.println(textBlock);
        System.out.println("this is before text blocks");
    }

    void after(){
        System.out.println("After text blocks:");

        var textBlock = """
                Java 30y "let's celebrate":
                    - Dominando o Seu Java com Propósito
                      Ronaldo Tavares
            """;

        System.out.println(textBlock);
        System.out.println("this is after text blocks");
    }

    void complexTextBlock(){
        System.out.println("Complex Text Block Example:");

        var textBlock = """
                Java 30y \"""let's celebrate\"\"\":     \s\n
                    - Dominando o Seu Java com Propósito\
                      Ronaldo Tavares""";

        System.out.println(textBlock);
        System.out.println("this is after complex text block");
    }
}
