package com.example.asbapp.data.repository

import com.example.asbapp.data.api.ASBApiService
import com.example.asbapp.domain.data.Transaction
import javax.inject.Inject

interface TransactionDataSource {
    suspend fun fetchAllTransactions(): List<Transaction>
}

class TransactionDataSourceImpl @Inject constructor(
    private val asbApiService: ASBApiService
): TransactionDataSource {
    override suspend fun fetchAllTransactions(): List<Transaction> = asbApiService.getTransactions()
        .map {
            Transaction(
                id = it.id,
                transactionDate = it.transactionDate,
                summary = it.summary,
                debit = it.debit,
                credit = it.credit
            )
        }

}