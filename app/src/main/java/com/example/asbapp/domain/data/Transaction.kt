package com.example.asbapp.domain.data

import java.io.Serializable

data class Transaction(
    val id: String,
    val transactionDate: String,
    val summary: String,
    val debit: Double,
    val credit: Double
): Serializable
