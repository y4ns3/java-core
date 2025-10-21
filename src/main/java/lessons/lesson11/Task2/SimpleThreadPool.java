package lessons.lesson11.Task2;

import java.util.*;

public class SimpleThreadPool {
    private final int poolSize;
    private final WorkerThread[] workers;
    private final Queue<Runnable> taskQueue;

    public SimpleThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new LinkedList<>();
        this.workers = new WorkerThread[poolSize];

        // Создаём и запускаем рабочие потоки
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread(taskQueue);
            new Thread(workers[i]).start();
        }
    }

    // Метод для добавления задач в пул
    public synchronized void submit(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();  // Оповещаем один из рабочих потоков
        }
    }

    // Закрытие пула и завершение всех потоков
    public void shutdown() {
        for (WorkerThread worker : workers) {
            worker.setRunning(false);
        }
    }
}
