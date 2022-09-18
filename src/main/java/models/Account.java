package models;

import enums.OperationType;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class Account {

    private static int uid = 0;

    private final int id;

    private String name;

    private BigDecimal balance;

    private Deque<History> history = new LinkedList<>();

    public Account(String name) {
        this.id = uid;
        this.name = name;
        this.balance = BigDecimal.valueOf(0);
        uid++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Deque<History> getHistory() {
        return history;
    }

    /**
     * Increase balance by given amount
     * Add operation history entry if operation successful
     * @param amount
     */
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
        this.addOperationHistory(OperationType.DEPOSIT, amount);
    }

    /**
     * Decrease balance by given amount if possible
     * Add operation history entry if operation successful
     * @param amount
     * @throws RuntimeException if amount required superior to account balance
     */
    public void withdrawal(BigDecimal amount) throws RuntimeException{
        if (this.balance.compareTo(amount) == -1){
            throw new RuntimeException("Not enough money in your account");
        }
        else{
            this.balance = this.balance.subtract(amount);
            this.addOperationHistory(OperationType.WITHDRAW, amount);
        }
    }

    /**
     * Add entry to the top of the list
     * @param operationType
     * @param amount
     */
    private void addOperationHistory(OperationType operationType, BigDecimal amount){
        this.history.addFirst(new History(operationType, amount, this.balance));
    }

    /**
     * Generate the history of all operation done on the account (by most recent to the oldest)
     * @return String with all operation history
     */
    public String printHistory(){
        StringBuilder stringBuilder = new StringBuilder("");
        for (History entry : this.getHistory()){
            stringBuilder.append(entry);
        }

        return stringBuilder.toString();
    }
}
