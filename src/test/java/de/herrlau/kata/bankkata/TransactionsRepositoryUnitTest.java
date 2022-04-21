package de.herrlau.kata.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionsRepositoryUnitTest {

    public static final String DATE = "12/05/2015";

    @Mock
    Clock clock;
    private TransactionsRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TransactionsRepository(clock);
        given(clock.dateAsString()).willReturn(DATE);
    }

    @Test
    void should_create_and_store_a_deposit_transaction() {
        repository.addDeposit(100);

        List<Transaction> transactions = repository.findAllTransactions();

        assertThat(transactions).hasSize(1)
                .first().isEqualTo(aTransaction(DATE, 100));
    }

    @Test
    void should_create_and_store_a_withdrawal_transaction() {
        repository.addWithdrawal(100);

        List<Transaction> transactions = repository.findAllTransactions();

        assertThat(transactions).hasSize(1)
                .first().isEqualTo(aTransaction(DATE, -100));
    }

    private Transaction aTransaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}