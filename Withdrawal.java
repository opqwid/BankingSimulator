/* Name: Vincent Qiu
 * Course: CNT 4714 Summer 2022
 * Assignment title: Project 1 - Synchronized, Cooperating Threads Under Locking
 * Due Date: June 5, 2022
 */

import java.util.Random;

public class Withdrawal implements Runnable {

    private static final int MAX_WITHDRAWAL = 99;
    private static Random generator = new Random();
    private ABankAccount sharedLocation;
    String tname;

    public Withdrawal(ABankAccount shared, String name) {

        sharedLocation = shared;
        tname = name;

    }

    // randomnly generates a number between 1-99 to withdraw from the shared account
    // then puts that thread to sleep for a random amount of time
    public void run() {
        
        while (true) {

            try {

                sharedLocation.withdraw(generator.nextInt(MAX_WITHDRAWAL-1+1)+1, tname);
                Thread.sleep(generator.nextInt(5));

            }
            catch (Exception e) {

                System.out.print("Exception thrown withdrawing !");

            }
        }
    }
}
