/* Name: Vincent Qiu
 * Course: CNT 4714 Summer 2022
 * Assignment title: Project 1 - Synchronized, Cooperating Threads Under Locking
 * Due Date: June 5, 2022
 */

import java.util.Random;

public class Depositor implements Runnable {

    private static final int MAX_DEPOSIT = 500;
    private static Random generator = new Random();
    private ABankAccount sharedLocation;
    String tname;
    
    public Depositor(ABankAccount shared, String name) {

        sharedLocation = shared;
        tname = name;
        
    }

    // randomly generates a number between 1-500 to deposit into the shared account
    // then puts that thread to sleep for a random amount of time
    public void run() {

        while(true) {

            try {
    
                sharedLocation.deposit(generator.nextInt(MAX_DEPOSIT-1+1)+1, tname);
                Thread.sleep(generator.nextInt(100));

            }
            catch (Exception exception) {

            }
        }
    }
}