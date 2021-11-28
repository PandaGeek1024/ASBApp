package com.example.asbapp.data.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val transactionDate: String,
    @ColumnInfo val summary: String,
    @ColumnInfo val debit: Double,
    @ColumnInfo val credit: Double
)