import java.util.*;

class ATM {
    float balance;
    int pin;

    public ATM(float initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public void checkPin() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your ATM pin: ");
            int enteredPin = sc.nextInt();
            if (enteredPin == pin) {
                System.out.println("Correct pin!");
                menu();
                break;
            } else {
                System.out.println("Incorrect pin!");
            }
        }
    }

    public void menu() {
        System.out.println("\n1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                System.out.println("Exiting ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                menu();
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
        menu();
    }

    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
        menu();
    }

    public void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Deposit successful! New balance: " + balance);
        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set your ATM pin: ");
        int userPin = sc.nextInt();
        
        ATM atm = new ATM(1000.0f, userPin);
        atm.checkPin();
    }
}
