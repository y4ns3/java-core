package lessons.lesson11.Task1;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Subscriber {
    private final int id;
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final AtomicBoolean running = new AtomicBoolean(true);

    public Subscriber(int id) {
        this.id = id;
    }

    public void start() {
        new Thread(() -> {
            try {
                while (running.get() || !queue.isEmpty()) {
                    String message = queue.poll(1, TimeUnit.SECONDS);
                    if (message != null) {
                        if (message.equalsIgnoreCase("exit")) {
                            System.out.println("Subscriber " + id + " exiting.");
                            break;
                        }
                        System.out.println("[Subscriber " + id + "] Received: " + message);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void receiveMessage(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        running.set(false);
    }
}
