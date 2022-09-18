package models;

import java.util.HashMap;

public class Bank {

    private HashMap<Integer, Account> customersAccount = new HashMap<>();

    public Bank() {
    }

    public HashMap<Integer, Account> getCustomersAccount() {
        return customersAccount;
    }

    /**
     * Create an Account with customer name and initial amount
     * @param name name of the customer
     * @return Account
     */
    public Account createAccount(String name){
        Account createdAccount = new Account(name);
        this.customersAccount.put(createdAccount.getId(), createdAccount);
        return createdAccount;
    }
}
