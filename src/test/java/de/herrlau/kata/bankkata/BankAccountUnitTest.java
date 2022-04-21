package de.herrlau.kata.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BankAccountUnitTest {

    @Mock
    TransactionsRepository repository;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(repository);
    }

    @Test
    void should_store_a_deposit_transaction() {
        account.deposit(100);
        verify(repository).addDeposit(100);
    }

    @Test
    void should_store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(repository).addWithdrawal(100);
    }

}