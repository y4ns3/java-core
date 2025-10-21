package lessons.lesson11.Task2;

public class Main {
    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool(3);

        // Добавляем 10 задач
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            threadPool.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                    Thread.sleep(1000); // имитация работы
                    System.out.println("Task " + taskId + " finished by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Завершаем работу пула
        threadPool.shutdown();
        System.out.println("All tasks submitted. Thread pool shutting down...");
    }
}
