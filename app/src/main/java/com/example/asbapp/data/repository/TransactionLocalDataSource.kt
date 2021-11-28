package com.example.asbapp.data.repository

import com.example.asbapp.data.db.dao.TransactionDao
import com.example.asbapp.data.db.table.TransactionEntity
import com.example.asbapp.domain.data.Transaction
import javax.inject.Inject

interface TransactionLocalDataSource {
    suspend fun getAllTransactions(): List<Transaction>
    suspend fun insertTransaction(transaction: Transaction): Long
}

class TransactionLocalDataSourceImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : TransactionLocalDataSource {
    override suspend fun getAllTransactions(): List<Transaction> =
        transactionDao.getAllTransactions().map {
            Transaction(
                id = it.id,
                transactionDate = it.transactionDate,
                summary = it.summary,
                debit = it.debit,
                credit = it.credit
            )
        }

    override suspend fun insertTransaction(transaction: Transaction): Long = transactionDao.insertTransaction(
        TransactionEntity(
            id = transaction.id,
            transactionDate = transaction.transactionDate,
            summary = transaction.summary,
            debit = transaction.debit,
            credit = transaction.credit
        )
    )

}