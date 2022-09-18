package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        this.account = new Account("Alice");
    }

    @Test
    @DisplayName("Should increase balance of account by given amount")
    void deposit() {
        assertEquals(account.getBalance(), BigDecimal.valueOf(0));
        account.deposit(BigDecimal.valueOf(10));
        assertEquals(account.getBalance(), BigDecimal.valueOf(10));
    }
}