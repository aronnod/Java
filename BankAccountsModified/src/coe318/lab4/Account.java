package coe318.lab4;

/**
 *
 * @author User
 */

public class Account {
    String c_name;
    int c_num;
    double bal;

    public Account(String name, int number, double initialBalance) {
        c_name = name;
        c_num = number;
        bal = initialBalance;
    }
    
    public String getName() {
    return c_name;
    }
    
    
    public int getNumber() {
    return c_num;
    }
    
    public double getBalance() {
    return bal;
    }    
    
    public boolean deposit(double amount) {
        if (amount > 0) {
            bal = bal + amount;
            return true;
        } 
        else {
            return false;
        }
     }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && bal > 0 && bal - amount > 0) {
            bal = bal - amount;
            return true;
        } 
        else {
            return false;
        }
     }    
    
    
    @Override
    public String toString() {
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
}



