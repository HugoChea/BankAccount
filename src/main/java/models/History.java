package models;

import enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class History {

    private OperationType operationType;

    private LocalDate date = LocalDate.now();

    private BigDecimal amount;

    private BigDecimal balance;

    public History(OperationType operationType, BigDecimal amount, BigDecimal balance) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return ""+date + " : " +
                "operationType='" + operationType + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '\n';
    }
}
