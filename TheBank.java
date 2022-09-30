/* Name: Vincent Qiu
 * Course: CNT 4714 Summer 2022
 * Assignment title: Project 1 - Synchronized, Cooperating Threads Under Locking
 * Due Date: June 5, 2022
 */

public interface TheBank {

    public abstract void deposit(int value, String name);

    public abstract void withdraw(int value, String name);

    public abstract void flagged_transaction(int value, String name, String trans_type);
    
}