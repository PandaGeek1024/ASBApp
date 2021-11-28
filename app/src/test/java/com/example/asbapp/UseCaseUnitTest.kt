package com.example.asbapp

import com.example.asbapp.data.repository.TransactionDataSource
import com.example.asbapp.data.repository.TransactionLocalDataSource
import com.example.asbapp.data.repository.TransactionRepositoryImpl
import com.example.asbapp.domain.usecase.GetAllTransactionsUseCase
import com.example.asbapp.domain.result.Result
import io.mockk.MockKAnnotations
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class UseCaseUnitTest {
    @RelaxedMockK
    lateinit var mockApiDataSource: TransactionDataSource

    @RelaxedMockK
    lateinit var mockLocalDataSource: TransactionLocalDataSource

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun loadTransactionsSuccessfully() = coroutineRule.runBlockingTest {
        coEvery { mockApiDataSource.fetchAllTransactions() } returns MockData.fakeTransactions
        coEvery { mockLocalDataSource.getAllTransactions() } returns MockData.fakeTransactions

        val useCase =
            GetAllTransactionsUseCase(
                TransactionRepositoryImpl(
                    apiDataSource = mockApiDataSource,
                    localDataSource = mockLocalDataSource
                ), coroutineRule.testDispatcher
            )
        val result = useCase(Unit)
        coVerify(exactly = 2) { mockLocalDataSource.insertTransaction(any()) }
        assertEquals(result, Result.Success(MockData.fakeTransactions))

        clearMocks(mockApiDataSource, mockLocalDataSource)
    }

    @Test
    fun loadTransactionsUnSuccessfully() = coroutineRule.runBlockingTest {
        coEvery { mockApiDataSource.fetchAllTransactions() }.throws(Exception("Error!"))

        val useCase =
            GetAllTransactionsUseCase(
                TransactionRepositoryImpl(
                    apiDataSource = mockApiDataSource,
                    localDataSource = mockLocalDataSource
                ), coroutineRule.testDispatcher
            )
        val result = useCase(Unit)

        assertTrue(result is Result.Error)

        clearMocks(mockApiDataSource, mockLocalDataSource)
    }
}