package de.herrlau.kata.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BankAccountAcceptanceTest {

    @Mock
    Console console;
    @Mock
    Clock clock;
    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        TransactionsRepository repository = new TransactionsRepository(clock);
        StatementPrinter printer = new StatementPrinter();
        bankAccount = new BankAccount(repository, printer);
    }

    @Test
    void an_account_should_print_statements_in_order() {

        bankAccount.deposit(1000);
        bankAccount.withdraw(100);
        bankAccount.deposit(500);
        bankAccount.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("Date       || Amount || Balance");
        inOrder.verify(console).printLine("14/01/2012 || -500   || 2500");
        inOrder.verify(console).printLine("13/01/2012 || 2000   || 3000");
        inOrder.verify(console).printLine("10/01/2012 || 1000   || 1000");
    }
}