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
    void should_increase_balance_when_deposit() {
        assertEquals(BigDecimal.valueOf(0), account.getBalance());
        account.deposit(BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(10), account.getBalance());
    }

    @Test
    @DisplayName("Should decrease balance of account by given amount")
    void should_decrease_balance_when_withdrawal() {
        account.deposit(BigDecimal.valueOf(100));
        account.withdrawal(BigDecimal.valueOf(10));
        assertEquals(account.getBalance(), BigDecimal.valueOf(90));
    }

    @Test
    @DisplayName("Should throw exception when withdraw more than account balance")
    void should_throw_runtime_exception_when_withdraw_more_than_account_balance() {
        assertThrows(RuntimeException.class, () -> account.withdrawal(BigDecimal.valueOf(10)));
    }
}