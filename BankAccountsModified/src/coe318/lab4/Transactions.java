package coe318.lab4;

import java.util.Scanner;

public class Transactions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the maximum number of accounts for the bank:");
        int maxAccounts = scanner.nextInt();
        Bank bank = new Bank("My Bank", maxAccounts);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add an account");
            System.out.println("2. Perform transactions");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account name:");
                    scanner.nextLine(); // consume the newline character
                    String accountName = scanner.nextLine();
                    System.out.println("Enter account number:");
                    int accountNumber = scanner.nextInt();
                    System.out.println("Enter initial balance:");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = new Account(accountName, accountNumber, initialBalance);
                    bank.add(newAccount);
                    System.out.println("Account added successfully!");
                    break;
                case 2:
                    System.out.println("Choose an action:");
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. Exit");

                    int transactionChoice = scanner.nextInt();
                    
                    String enteredAccountName = null;
                    if (transactionChoice != 3) {
                        System.out.println("Please Type in a Valid Account Name:");
                        scanner.nextLine(); // consume the newline character
                        enteredAccountName = scanner.nextLine();
                    }

                    // Check if the user chose to exit
                    if (transactionChoice == 3) {
                        System.out.println("Exiting Transaction Terminal...");
                        break; // Exit the loop for performing transactions
                    }

                    Account selectedAccount = null;
                    for (Account account : bank.getAccounts()) {
                        if (account != null && account.getName().equals(enteredAccountName)) {
                            selectedAccount = account;
                            break;
                        }
                    }

                    if (selectedAccount != null) {
                        switch (transactionChoice) {
                            case 1:
                                System.out.println("Please Type in Your Deposit Amount: ");
                                double depositAmount = scanner.nextDouble();
                                selectedAccount.deposit(depositAmount);
                                System.out.println("Deposit successful. New balance: " + selectedAccount.getBalance());
                                break;
                            case 2:
                                System.out.println("Please Type in Your Withdraw Amount: ");
                                double withdrawAmount = scanner.nextDouble();
                                if (selectedAccount.withdraw(withdrawAmount)) {
                                    System.out.println("Withdrawal successful. New balance: " + selectedAccount.getBalance());
                                } else {
                                    System.out.println("Withdrawal failed. Insufficient funds.");
                                }
                                break;
                            case 3:
                                System.out.println("Exiting Transaction Terminal...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose again.");
                                break;
                        }
                    } else {
                        System.out.println("Account not found. Please check the account name and try again.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}
