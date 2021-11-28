package com.example.asbapp.data.entity

data class TransactionResponse(
    val id: String,
    val transactionDate: String,
    val summary: String,
    val debit: Double,
    val credit: Double
)