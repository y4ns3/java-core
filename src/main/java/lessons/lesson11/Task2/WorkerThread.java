package lessons.lesson11.Task2;

import java.util.Queue;

public class WorkerThread implements Runnable {
    private final Queue<Runnable> taskQueue;
    private boolean isRunning = true;

    public WorkerThread(Queue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (isRunning) {
            Runnable task = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && isRunning) {
                    try {
                        taskQueue.wait();  // Ожидаем задачу
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (isRunning) {
                    task = taskQueue.poll();  // Извлекаем задачу из очереди
                }
            }

            // Выполнение задачи, если она есть
            if (task != null) {
                task.run();
            }
        }
    }

    // Остановка потока
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
