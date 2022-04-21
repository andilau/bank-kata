package de.herrlau.kata.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterUnitTest {

    private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    @Mock
    Console console;
    StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void should_always_print_header_first() {

        statementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine("Date | Amount | Balance");
    }

    @Test
    void should_print_transactions_in_reverse_chronological_order() {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("10/01/2012", 1000),
                new Transaction("13/01/2012", -100),
                new Transaction("14/01/2012", 500)
        );
        statementPrinter.print(transactions);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("Date | Amount | Balance");
        inOrder.verify(console).printLine("14/01/2012 | 500 | 1400");
        inOrder.verify(console).printLine("13/01/2012 | -100 | 900");
        inOrder.verify(console).printLine("10/01/2012 | 1000 | 1000");

    }

}