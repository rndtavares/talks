package dev.ronaldotavares.talks;

public class PatternMatching {
    public static void main(String[] args) {
        System.out.println("Pattern Matching");

        var patternMatching = new PatternMatching();
        patternMatching.before(10);
        patternMatching.after(10);
        patternMatching.finalPatternVariables(8);
        patternMatching.withConditionalClause(15);
        patternMatching.withNullPatternVariable();
        patternMatching.worksOnlyWithSupportedTypes();
        patternMatching.flowScoping();
    }

    void before(Number number){
        System.out.println("Before pattern matching:");
        if (number instanceof Integer) {
            Integer data = (Integer)number;
            System.out.println(data.compareTo(10));
        }
    }

    void after(Number number){
        System.out.println("After pattern matching:");
        if (number instanceof Integer data) {
            System.out.println(data.compareTo(10));
        }
    }

    void finalPatternVariables(Number number) {
        System.out.println("Pattern matching with final variables");
        if (number instanceof final Integer data) {
//             data = 10;  // DOES NOT COMPILE
        }
    }

    void withConditionalClause(Number number) {
        System.out.println("Pattern matching with conditional clause");
        if (number instanceof Integer data && data.compareTo(10) > 0)
            System.out.println(data);
    }

    void withNullPatternVariable() {
        System.out.println("Pattern matching with null");
        String nullObject = null;
        if(nullObject instanceof String s && s.length() > -1)
            System.out.println("It is always false");
    }

    void worksOnlyWithSupportedTypes() {
        System.out.println("Pattern matching works only with supported types");
        Number number = Integer.valueOf(123);
        if (number instanceof Integer i) {}
        if (number instanceof Number n) {}
//        if (number instanceof String s) {} // DOES NOT COMPILE
        if (number instanceof Object o) {}
    }

    void flowScoping() {
        System.out.println("Pattern matching flow scoping");
        doesNotWorksWithoutGuarantee(10);
        outOfScope(20);
        reversedScope(30);
    }

    void doesNotWorksWithoutGuarantee(Number number) {
        System.out.println("Pattern matching does not work without guarantee");
//         if (number instanceof Integer data || data.compareTo(10) > 0)
//            System.out.print(data);
    }

    void outOfScope(Number number) {
        System.out.println("Pattern matching variable out of scope");
        if (number instanceof Integer data)
            System.out.println(data.intValue());
//         System.out.print(data.intValue());  // DOES NOT COMPILE
    }

    void reversedScope(Number number) {
        System.out.println("Pattern matching with only integers");
        if (!(number instanceof Integer data))
            return;
        System.out.println(data.intValue());
    }
}
