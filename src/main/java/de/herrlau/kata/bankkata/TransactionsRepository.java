package de.herrlau.kata.bankkata;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionsRepository {

    private final Clock clock;
    private final List<Transaction> transactions;

    public TransactionsRepository(Clock clock) {
        this.clock = clock;
        this.transactions = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        var deposit = new Transaction(clock.dateAsString(), amount);
        transactions.add(deposit);
    }

    public void addWithdrawal(int amount) {
        var withdraw = new Transaction(clock.dateAsString(), -amount);
        transactions.add(withdraw);
    }

    public List<Transaction> findAllTransactions() {
        return unmodifiableList(transactions);
    }
}
