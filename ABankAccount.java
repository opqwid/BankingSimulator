/* Name: Vincent Qiu
 * Course: CNT 4714 Summer 2022
 * Assignment title: Project 1 - Synchronized, Cooperating Threads Under Locking
 * Due Date: June 5, 2022
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class ABankAccount implements TheBank {

    int balance = 0;
    int depAmount = 0;
    int witAmount = 0;
    private Lock accessLock = new ReentrantLock();
    private Condition canWrite = accessLock.newCondition();
    private Condition canRead = accessLock.newCondition();

    private boolean occupied = false;
    
    // Outputs the flagged transactions into a text file
    public void flagged_transaction(int value, String transaction_thread, String transaction_type) {

        try {
        

            if (transaction_type.equals("?")) {
               
            }
            else {
            
            }
        }
        catch (Exception ioException) {

            System.out.println("\nError: Problem writing to transaction file.\n");

        }
        finally {

        }
    }

    public void deposit(int value, String dep) {

        accessLock.lock();

        try {

            while ( occupied ) {
                canWrite.await();
            }

            occupied = true;
            System.out.println("\t\t\t\t\t\t\t\t\tBalance is $" + balance);
            balance += value;
            depAmount = value;
            
            // Checks if the deposited amount is over 350 and flags it.
            if (value > 350) {
                flagged_transaction(value, dep, "?");
                System.out.println("Agent " + dep + " deposits $" + depAmount);
                System.out.println("* * * Flagged Transaction - Depositor Agent " + dep + " Made A Deposit In Excess Of $350.00 USD - See Flagged Transaction Log.");
            }
            else {
                System.out.println("Agent " + dep + " deposits $" + depAmount);
            }
            canRead.signal();
        }
        catch (InterruptedException exception) {

            exception.printStackTrace();
            System.out.println("An Exception was thrown getting the withdrawal.");

        }
        finally {

            accessLock.unlock();

        }

    }

    public void withdraw(int value, String wit) {

        accessLock.lock();

        try {

            while (!occupied)
            {
                canRead.await();
            }
            // Checks to see if there is enough money in the shared account
            if (balance - value < 0) {
                
                System.out.println("\t\t\t\tAgent " + wit + " withdraws $" + witAmount + "\t\t\t(******) WITHDRAWAL BLOCKED - INSUFFICIENT FUNDS!!!");
                occupied = false;
            }
            else {

                System.out.println("\t\t\t\t\t\t\t\t\tBalance is $" + balance);
                balance -= value;
                witAmount = value;
                
                // Checks if the withdrawn value is over the value of 75 and flags it
                if (value > 75) {

                    flagged_transaction(value, wit, "?");
                    System.out.println("\t\t\t\tAgent " + wit + " withdraws $" + witAmount);
                    System.out.println("\n* * * Flagged Transaction - Withdrawal Agent " + wit + " Made A Withdrawal In Excess Of $75.00 USD - See Flagged Transaction Log.\n");
                }
                else {
                    System.out.println("\t\t\t\tAgent " + wit + " withdraws $" + witAmount);
                }
            }
            canWrite.signal();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        finally {

            accessLock.unlock();

        }
        
    }
}