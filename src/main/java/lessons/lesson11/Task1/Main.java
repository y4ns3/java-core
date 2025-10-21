package lessons.lesson11.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new Subscriber(1);

        publisher.subscribe(subscriber1);

        subscriber1.start();


        while (true) {
            String input = scanner.nextLine();
            publisher.publish(input);
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
        }
        publisher.close();
        scanner.close();
    }
}
