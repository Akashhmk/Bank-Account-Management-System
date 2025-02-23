import java.util.*;
import java.util.logging.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidDepositAmountException {
        if (amount <= 0) {
            throw new InvalidDepositAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        logger.info("Deposited: " + amount + " | New Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        logger.info("Withdrawn: " + amount + " | New Balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
