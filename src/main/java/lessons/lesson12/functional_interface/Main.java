package lessons.lesson12.functional_interface;

import java.util.*;
import java.util.function.*;


public class Main {
    public static void main(String[] args) {
        Predicate<String> isValid = s -> s != null && !s.isEmpty() && s.length() > 3;
        System.out.println(isValid.test("Hi"));      // false
        System.out.println(isValid.test("Hello"));   // true
        System.out.println();

        Function<String, Integer> lengthFunc = String::length;
        System.out.println(lengthFunc.apply("banana")); // 6
        System.out.println();

        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        System.out.println(uuidSupplier.get());
        System.out.println(uuidSupplier.get());
        System.out.println();

        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        printUpper.accept("hello world");
        System.out.println();

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(5, 7)); // 12
        System.out.println();

        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> trimThenUpper = trim.andThen(toUpper);
        System.out.println(trimThenUpper.apply("   hello   ")); // "HELLO"
        System.out.println();

        Consumer<String> printString = s -> System.out.println("Строка: " + s);
        Consumer<String> printLength = s -> System.out.println("Длина: " + s.length());
        Consumer<String> combined = printString.andThen(printLength);
        combined.accept("Banana");
        System.out.println();

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> oddOrNegative = isEven.negate().or(isPositive.negate());
        System.out.println(oddOrNegative.test(1));
        System.out.println(oddOrNegative.test(2));
        System.out.println(oddOrNegative.test(-3));
        System.out.println();

        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        String result = multiply.andThen(toStr).apply(3, 4);
        System.out.println(result);
        System.out.println();

        UnaryOperator<String> addExclamation = s -> s + "!!!";
        System.out.println(addExclamation.apply("Abc"));
        System.out.println();

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evens = new ArrayList<>();
        for (Integer n : nums) {
            if (n % 2 == 0) evens.add(n);
        }
        System.out.println(evens);
        System.out.println();

        List<String> strings = List.of("hi", "apple", "java");
        List<Integer> lengths = new ArrayList<>();
        for (String s : strings) {
            lengths.add(s.length());
        }
        System.out.println(lengths);
        System.out.println();

        for (String s : strings) {
            System.out.println("-> " + s);
        }
        System.out.println();

        List<UUID> uuids = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            uuids.add(UUID.randomUUID());
        }
        uuids.forEach(System.out::println);

    }
}
