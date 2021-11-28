package com.example.asbapp.presentation.di

import android.content.Context
import com.example.asbapp.data.api.ASBApiService
import com.example.asbapp.data.api.AsbApi
import com.example.asbapp.data.db.AsbDatabase
import com.example.asbapp.data.repository.TransactionDataSource
import com.example.asbapp.data.repository.TransactionDataSourceImpl
import com.example.asbapp.data.repository.TransactionLocalDataSource
import com.example.asbapp.data.repository.TransactionLocalDataSourceImpl
import com.example.asbapp.data.repository.TransactionRepositoryImpl
import com.example.asbapp.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideAsbApiService(): ASBApiService = AsbApi.asbApiService

    @Singleton
    @Provides
    fun provideAsbDatabase(@ApplicationContext context: Context): AsbDatabase =
        AsbDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideTransactionLocalDataSource(db: AsbDatabase): TransactionLocalDataSource {
        return TransactionLocalDataSourceImpl(db.transactionDao())
    }
}

@InstallIn(SingletonComponent::class)
@Module
abstract class AppBindModule {
    @Singleton
    @Binds
    abstract fun bindTransactionDataSource(impl: TransactionDataSourceImpl): TransactionDataSource

    @Singleton
    @Binds
    abstract fun bindTransactionRepository(impl: TransactionRepositoryImpl): TransactionRepository
}