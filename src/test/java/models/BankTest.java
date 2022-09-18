package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        this.bank = new Bank();
    }

    @Test
    @DisplayName("Should create account and store in customers account list")
    void should_have_one_customer_account_when_create_account() {
        assertEquals(bank.getCustomersAccount().size(), 0);
        Account createdAccount = bank.createAccount("Alice");

        assertEquals(bank.getCustomersAccount().size(), 1);
        assertTrue(bank.getCustomersAccount().containsKey(createdAccount.getId()));
        assertEquals(bank.getCustomersAccount().get(createdAccount.getId()), createdAccount);
    }

    @Test
    @DisplayName("Should create multiple account and store all of them in customers account list")
    void should_have_multiple_customer_account_when_create_account_multiple_times() {
        assertEquals(bank.getCustomersAccount().size(), 0);
        bank.createAccount("Alice");
        bank.createAccount("John");
        bank.createAccount("Elisabeth");
        assertEquals(bank.getCustomersAccount().size(), 3);
    }

}