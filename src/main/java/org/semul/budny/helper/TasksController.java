package org.semul.budny.helper;

import java.util.LinkedList;
import java.util.List;

public class TasksController extends Thread implements Controller{
    public static List<Task> tasks = new LinkedList<>();

    public static Controller getInstance() {
        TasksController controller = new TasksController();
        controller.start();
        ThreadsController.threads.add(controller);

        return controller;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                tasks.removeIf(task -> task.getState() == State.TERMINATED);
                Thread.sleep(10000);
            }
        } catch (InterruptedException ignored) {
            for (Task task : tasks) {
                task.interrupt();
            }

            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void halt() {
        this.interrupt();
    }
}
