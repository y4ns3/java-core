package lessons.lesson12.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        for (Integer number : numbers) {
            if (number % 2 == 0){
                System.out.println(number*number);
            }
        }
        numbers
            .stream()
            .filter(n->n%2==0)
            .map(n->n*n)
            .forEach(System.out::println);

        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        for (String word : words) {
            if(word.length() >5){
                System.out.println(word);
            }
        }
        words.stream()
            .filter(n->n.length() >5)
            .forEach(System.out::println);

        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        System.out.println("min value:"+nums.stream().min(Integer::compareTo).get());
        System.out.println("max value:"+nums.stream().max(Integer::compareTo).get());

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        double avgLength = names.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0);
        System.out.println("avg length: " + avgLength);

        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        input.stream()
            .distinct()
            .sorted(Comparator.comparingInt(String::length))
            .forEach(System.out::println);

        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = fruits.stream()
            .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        List<String> people = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> grouped = people.stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(grouped);

        List<String> pets = List.of("Tom", "Jerry", "Spike");
        String joined = pets.stream()
            .collect(Collectors.joining(", "));
        System.out.println(joined);

        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> allWords = sentences.stream()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .toList();
        System.out.println(allWords);

        record Product(String name, String category, double price) {}
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0)
        );
        Map<String, Optional<Product>> expensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::category,
                Collectors.maxBy(Comparator.comparingDouble(Product::price))
            ));
        System.out.println(expensiveByCategory);
    }

}
