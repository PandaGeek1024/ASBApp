package com.example.asbapp.domain.usecase

import com.example.asbapp.domain.data.Transaction
import com.example.asbapp.domain.repository.TransactionRepository
import com.example.asbapp.presentation.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, List<Transaction>>(ioDispatcher) {
    override suspend fun execute(parameters: Unit): List<Transaction> =
        transactionRepository.getAllTransactions()
}