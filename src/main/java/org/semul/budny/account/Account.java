package org.semul.budny.account;

import org.semul.budny.connection.Session;
import org.semul.budny.exception.FailEmployException;
import org.semul.budny.exception.StartSessionException;

import java.util.LinkedList;
import java.util.Queue;

public class Account extends Thread {
    private final String username;
    private final String password;
    private boolean status;
    private volatile boolean completionStatus;
    private Session session;
    private final Queue<Intention> taskQueue;

    public enum Intention {
        LAUNCH, DISABLE, EMPLOY
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.status = true;
        this.taskQueue = new LinkedList<>();
        this.completionStatus = false;
        this.session = null;
    }

    public void addTask(Intention intention) {
        this.taskQueue.add(intention);
    }

    @Override
    public void run() {
        while (this.status) {
            if (this.taskQueue.size() > 0) {
                switch (this.taskQueue.poll()) {
                    case LAUNCH -> launch();
                    case DISABLE -> disable();
                    case EMPLOY -> employ();
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // *** Intentions ***
    private void launch() {
        this.session = new Session(this.username, this.password);

        try {
            this.session.start();
        } catch (StartSessionException e) {
            System.out.println(e.getMessage());
            disable();
        } finally {
            this.completionStatus = true;
        }
    }

    private void disable() {
        if (this.session != null) {
            this.session.interrupt();
            this.session = null;
        }

        this.status = false;
        this.completionStatus = true;
    }

    private void employ() {
        try {
            this.session.employ();
        } catch (FailEmployException e) {
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getStatus() {
        return this.status;
    }

    public boolean getCompletionStatus() {
        return this.completionStatus;
    }

    public void changeCompletionStatus() {
        this.completionStatus = !this.completionStatus;
    }

    @Override
    public String toString() {
        return "\n● Account:\n▬▬ username: " + this.username + ";\n" + "▬▬ password: " + this.password + ";\n"
                + "▬▬ status: " + (this.status ? "launched" : "stopped") + ";\n";
    }
}
