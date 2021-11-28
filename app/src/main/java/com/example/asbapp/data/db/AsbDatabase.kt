package com.example.asbapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.asbapp.data.db.dao.TransactionDao
import com.example.asbapp.data.db.table.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 1)
abstract class AsbDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        fun getInstance(context: Context): AsbDatabase {
            return Room.databaseBuilder(
                context,
                AsbDatabase::class.java, "asbDB.db"
            ).build()
        }
    }
}