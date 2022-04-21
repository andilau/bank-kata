package de.herrlau.kata.bankkata;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "Date | Amount | Balance";
    private final Console console;

    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
        printStatements(transactions);
    }

    private void printStatements(List<Transaction> transactions) {
        AtomicInteger balance = new AtomicInteger();
        transactions.stream()
                .map(t -> statementLine(t, balance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction t, AtomicInteger balance) {
        return String.format("%s | %d | %d",
                t.date(),
                t.amount(),
                balance.addAndGet(t.amount()));
    }
}
