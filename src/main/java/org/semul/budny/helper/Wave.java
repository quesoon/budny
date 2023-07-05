package org.semul.budny.helper;

import org.semul.budny.account.Account;
import org.semul.budny.manager.Manager;

import java.util.Objects;

public class Wave extends Thread {
    public static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Wave.class);
    private Manager manager;
    private Account account;
    private Account.Intention intent;
    private final int countdown;

    public Wave(Manager manager, Account account, Account.Intention intent, int countdown) {
        logger.info("Initialization...");
        this.manager = manager;
        this.account = account;
        this.intent = intent;
        this.countdown = countdown;
        logger.info("Done.");
    }

    @Override
    public void run() {
        logger.info("Signal to the manager about '" + intent + "' in " + this.countdown + " seconds.");

        try {
            Thread.sleep(countdown * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("Signal to the manager about '" + intent + '.');

        if (Objects.requireNonNull(intent) == Account.Intention.EMPLOY) {
            manager.getJob(account);
        }

        clear();
    }

    private void clear() {
        logger.info("Interrupt wave...");
        this.manager = null;
        this.account = null;
        this.intent = null;
        logger.info("Done.");
    }
}
