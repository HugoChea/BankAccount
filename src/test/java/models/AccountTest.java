package models;

import enums.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        assertEquals(BigDecimal.valueOf(90), account.getBalance());
    }

    @Test
    @DisplayName("Should throw exception when withdraw more than account balance")
    void should_throw_runtime_exception_when_withdraw_more_than_account_balance() {
        assertThrows(RuntimeException.class, () -> account.withdrawal(BigDecimal.valueOf(10)));
    }

    @Test
    @DisplayName("Should add operation history")
    void should_insert_one_history_entry_when_add_operation_history() {
        assertEquals(0, account.getHistory().size());
        account.deposit(BigDecimal.valueOf(10));
        assertEquals(1, account.getHistory().size());
        History addedHistory = account.getHistory().getFirst();
        assertEquals(addedHistory.getOperationType(), OperationType.DEPOSIT);
        assertEquals(addedHistory.getAmount(), BigDecimal.valueOf(10));
        assertEquals(addedHistory.getBalance(), BigDecimal.valueOf(10));
        assertEquals(addedHistory.getDate(), LocalDate.now());
    }

    @Test
    @DisplayName("Should add one operation history entry when deposit")
    void should_add_operation_history_when_deposit() {
        assertEquals(0, account.getHistory().size());
        account.deposit(BigDecimal.valueOf(10));
        assertEquals(1, account.getHistory().size());
    }

    @Test
    @DisplayName("Should add one operation history entry when withdrawal")
    void should_add_operation_history_when_withdrawal() {
        assertEquals(0, account.getHistory().size());
        account.deposit(BigDecimal.valueOf(10));
        account.withdrawal(BigDecimal.valueOf(10));
        assertEquals(2, account.getHistory().size());
    }

    @Test
    @DisplayName("Should return string of all operations history")
    void should_return_string_with_all_operation_when_printing_history() {
        account.deposit(BigDecimal.valueOf(10));
        account.deposit(BigDecimal.valueOf(50));

        String expectedPrint = "" + LocalDate.now() + " : " +
                "operationType='" + OperationType.DEPOSIT + '\'' +
                ", date=" + LocalDate.now() +
                ", amount=50, balance=60" +
                '\n' +
                LocalDate.now()  + " : " +
                "operationType='" + OperationType.DEPOSIT + '\'' +
                ", date=" + LocalDate.now() +
                ", amount=10, balance=10" +
                '\n';
        assertEquals(expectedPrint, account.printHistory());
    }
}