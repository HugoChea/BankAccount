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
        assertEquals(0, bank.getCustomersAccount().size());
        Account createdAccount = bank.createAccount("Alice");

        assertEquals(1, bank.getCustomersAccount().size());
        assertTrue(bank.getCustomersAccount().containsKey(createdAccount.getId()));
        assertEquals(createdAccount, bank.getCustomersAccount().get(createdAccount.getId()));
    }

    @Test
    @DisplayName("Should create multiple account and store all of them in customers account list")
    void should_have_multiple_customer_account_when_create_account_multiple_times() {
        assertEquals(0, bank.getCustomersAccount().size());
        bank.createAccount("Alice");
        bank.createAccount("John");
        bank.createAccount("Elisabeth");
        assertEquals(3, bank.getCustomersAccount().size());
    }

}