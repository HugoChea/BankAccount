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
}
