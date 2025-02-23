import java.util.*;
import java.util.logging.*;

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(BankAccountManagementSystem.class.getName());
        Scanner scanner = new Scanner(System.in);

        // Create a sample account
        BankAccount account = new BankAccount("123456789", "Akash", 1000.00);

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.displayAccountInfo();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (Exception e) {
                logger.severe("Error: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
