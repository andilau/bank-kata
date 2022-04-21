package de.herrlau.kata.bankkata;

public interface Account {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}