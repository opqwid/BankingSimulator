/* Name: Vincent Qiu
 * Course: CNT 4714 Summer 2022
 * Assignment title: Project 1 - Synchronized, Cooperating Threads Under Locking
 * Due Date: June 5, 2022
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ABankingSimulator {

    public static final int MAX_AGENTS = 15;

    public static void main(String[] args) {

        ExecutorService application = Executors.newFixedThreadPool(MAX_AGENTS);

        ABankAccount sharedLocation = new ABankAccount();

        // Creating the 5 Depositor agents and 10 Withdrawal agents
        Depositor DT1 = new Depositor(sharedLocation, "DT1");
        Depositor DT2 = new Depositor(sharedLocation, "DT2");
        Depositor DT3 = new Depositor(sharedLocation, "DT3");
        Depositor DT4 = new Depositor(sharedLocation, "DT4");
        Depositor DT5 = new Depositor(sharedLocation, "DT5");
        Withdrawal WT1 = new Withdrawal(sharedLocation, "WT1");
        Withdrawal WT2 = new Withdrawal(sharedLocation, "WT2");
        Withdrawal WT3 = new Withdrawal(sharedLocation, "WT3");
        Withdrawal WT4 = new Withdrawal(sharedLocation, "WT4");
        Withdrawal WT5 = new Withdrawal(sharedLocation, "WT5");
        Withdrawal WT6 = new Withdrawal(sharedLocation, "WT6");
        Withdrawal WT7 = new Withdrawal(sharedLocation, "WT7");
        Withdrawal WT8 = new Withdrawal(sharedLocation, "WT8");
        Withdrawal WT9 = new Withdrawal(sharedLocation, "WT9");
        Withdrawal WT10 = new Withdrawal(sharedLocation, "WT10");


        try {
            
            // The depositing and withdrawing agents begin to do their work
            System.out.println("Deposit Agents         \t\tWithdrawal  Agents      \t\tBalance");
            System.out.println("-----------------------\t\t------------------------\t\t--------------------"); 

            application.execute(DT1);
            application.execute(DT2);
            application.execute(DT3);
            application.execute(DT4);
            application.execute(DT5);
            application.execute(WT1);
            application.execute(WT2);
            application.execute(WT3);
            application.execute(WT4);
            application.execute(WT5);
            application.execute(WT6);
            application.execute(WT7);
            application.execute(WT8);
            application.execute(WT9);
            application.execute(WT10);

        }
        catch (Exception exception) {

            exception.printStackTrace();
            
        }

        application.shutdown();
    }
}