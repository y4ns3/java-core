package lessons.lesson11.Task1;

import java.util.*;
import java.util.concurrent.*;

public class Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public synchronized void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public synchronized void publish(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveMessage(message);
        }
    }

    public synchronized void close() {
        for (Subscriber subscriber : subscribers) {
            subscriber.stop();
        }
    }
}
