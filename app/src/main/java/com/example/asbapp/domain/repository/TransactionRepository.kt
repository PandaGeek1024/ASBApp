package com.example.asbapp.domain.repository

import com.example.asbapp.domain.data.Transaction

interface TransactionRepository {
    suspend fun getAllTransactions(): List<Transaction>
}