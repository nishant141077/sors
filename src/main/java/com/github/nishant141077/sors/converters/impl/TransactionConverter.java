package com.github.nishant141077.sors.converters.impl;

import com.github.nishant141077.sors.converters.IModelConverter;
import com.github.nishant141077.sors.db.StoredTransaction;
import com.github.nishant141077.sors.models.transaction.Transaction;
import com.google.inject.Singleton;

@Singleton
public class TransactionConverter implements IModelConverter<StoredTransaction, Transaction> {

  @Override
  public Transaction toDto(StoredTransaction storedTransaction) {
    return Transaction.builder()
        .transactionId(storedTransaction.getTransactionId())
        .type(storedTransaction.getType())
        .transactionTime(storedTransaction.getTransactionTime())
        .amount(storedTransaction.getAmount())
        .investmentId(storedTransaction.getInvestmentId())
        .goalId(storedTransaction.getGoalId())
        .platform(storedTransaction.getPlatform())
        .createdAt(storedTransaction.getCreatedAt())
        .updatedAt(storedTransaction.getUpdatedAt())
        .build();
  }

  @Override
  public StoredTransaction toDao(Transaction transaction) {
    return StoredTransaction.builder()
        .transactionId(transaction.getTransactionId())
        .type(transaction.getType())
        .transactionTime(transaction.getTransactionTime())
        .amount(transaction.getAmount())
        .investmentId(transaction.getInvestmentId())
        .goalId(transaction.getGoalId())
        .platform(transaction.getPlatform())
        .build();
  }
}
