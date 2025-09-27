package com.autobots.java.bankApplication;

public class DemirBank extends BankBase{

    private double balance = 500;

    public DemirBank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addAllBankRecords(this);
    }


    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 500000) {
            throw new IllegalArgumentException("Invalid amount! Can not be deposit");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0 || amount >= 450000) {
            throw new IllegalArgumentException("Invalid amount can not be withdraw");
        }else {
            if (amount > balance){
                throw new IllegalArgumentException("Insufficient funds");
            }else {
                balance -= amount;
            }
        }
    }

}
