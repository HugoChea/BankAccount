import models.Account;
import models.Bank;

import java.math.BigDecimal;

public class BankAccountApp {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Account createdAccount = bank.createAccount("Alice");
        createdAccount.deposit(BigDecimal.valueOf(100));
    }
}
