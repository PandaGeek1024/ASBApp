package com.example.asbapp.data.repository

import com.example.asbapp.domain.data.Transaction
import com.example.asbapp.domain.repository.TransactionRepository
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val apiDataSource: TransactionDataSource,
    private val localDataSource: TransactionLocalDataSource
) : TransactionRepository {
    override suspend fun getAllTransactions(): List<Transaction> {
       val transactions = apiDataSource.fetchAllTransactions()
        transactions.forEach {
            localDataSource.insertTransaction(it)
        }
        return localDataSource.getAllTransactions();
    }

}