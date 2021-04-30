package src.Domain.Interfaces;

import src.Domain.Transaction;

public interface IAccount {
    void deposit(Transaction transaction) throws IllegalArgumentException;
    void withdraw(Transaction transaction) throws IllegalArgumentException;
    String extract();
}
