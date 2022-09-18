import models.Account;
import models.Bank;

import java.math.BigDecimal;

public class BankAccountApp {

    public static void main(String[] args) {
        // initialize bank
        Bank bank = new Bank();
        // create an account in the bank
        Account createdAccount = bank.createAccount("Alice");
        // feature 1 - deposit money on created account
        createdAccount.deposit(BigDecimal.valueOf(100));
        // feature 2 - withdraw money from account
        createdAccount.withdrawal(BigDecimal.valueOf(50));
        // feature 3 - print operation history of account
        System.out.println(createdAccount.printHistory());
    }
}
