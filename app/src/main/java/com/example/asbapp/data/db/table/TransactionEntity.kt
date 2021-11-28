package com.example.asbapp.data.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: String? = null,
    @ColumnInfo(name = "transactionDate") val transactionDate: String,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "debit") val debit: Double,
    @ColumnInfo(name = "credit") val credit: Double
)