package models;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Account {

    private static int uid = 0;

    private final int id;

    private String name;

    private BigDecimal balance;

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

    /**
     * Increase balance by given amount
     * @param amount
     */
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    /**
     * Decrease balance by given amount if possible
     * @param amount
     * @throws RuntimeException if amount required superior to account balance
     */
    public void withdrawal(BigDecimal amount){
        if (this.balance.compareTo(amount) == -1){
            throw new RuntimeException("Not enough money in your account");
        }
        else{
            this.balance = this.balance.subtract(amount);
        }
    }
}
