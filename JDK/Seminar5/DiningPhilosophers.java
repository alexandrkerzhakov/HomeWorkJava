package GeekBrains.JDK.Seminar5;

import java.util.Random;

class Fork {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void putDown() {
        taken = false;
        notifyAll();
    }
}

class Philosopher extends Thread {
    private final Fork leftFork;
    private final Fork rightFork;
    private int mealsEaten = 0;
    private static final int MEALS_TO_EAT = 3;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (mealsEaten < MEALS_TO_EAT) {
                think();
                eat();
                mealsEaten++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is thinking.");
        Thread.sleep(new Random().nextInt(1000)); // Random thinking time
    }

    private void eat() throws InterruptedException {
        leftFork.take();
        rightFork.take();
        try {
            System.out.println(Thread.currentThread().getName() + " is eating.");
            Thread.sleep(new Random().nextInt(1000)); // Random eating time
        } finally {
            leftFork.putDown();
            rightFork.putDown();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Fork[] forks = new Fork[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new Philosopher(leftFork, rightFork);
            philosophers[i].start();
        }
    }
}
