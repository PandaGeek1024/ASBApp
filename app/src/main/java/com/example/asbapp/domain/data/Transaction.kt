package com.example.asbapp.domain.data

data class Transaction(
    val id: String,
    val transactionDate: String,
    val summary: String,
    val debit: Double,
    val credit: Double
)
