package de.herrlau.kata.bankkata;

public record BankAccount(
        TransactionsRepository repository,
        StatementPrinter printer) implements Account {

    public void deposit(int amount) {
        repository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        repository.addWithdrawal(amount);
    }

    public void printStatement() {
        printer.print(repository.findAllTransactions());
    }
}
