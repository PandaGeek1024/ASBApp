package com.example.asbapp

import com.example.asbapp.domain.data.Transaction

object MockData {
    val fakeTransactions = listOf(
        Transaction(
            id = "1",
            transactionDate = "2021-02-02T08:11:16+13:00",
            summary = "Fancy Food Market Auckland",
            debit = 197.9,
            credit = 0.0
        ),
        Transaction(
            id = "2",
            transactionDate = "2021-02-03T00:06:37+13:00",
            summary = "Parking Auckland",
            debit = 8.25,
            credit = 0.0
        )
    )
}