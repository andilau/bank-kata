package de.herrlau.kata.bankkata;

public record BankAccount(TransactionsRepository repository) implements Account {

    public void deposit(int amount) {
        repository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        repository.addWithdrawal(amount);
    }

    public void printStatement() {
    }
}
