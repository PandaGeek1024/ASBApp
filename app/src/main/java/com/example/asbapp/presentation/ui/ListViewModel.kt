package com.example.asbapp.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asbapp.domain.data.Transaction
import com.example.asbapp.domain.result.SingleLiveEvent
import com.example.asbapp.domain.result.Result
import com.example.asbapp.domain.usecase.GetAllTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase
) : ViewModel() {
    val errorMessage = SingleLiveEvent<String>()

    private val _allTransactions = MutableLiveData<List<Transaction>>()
    val allTransactions: LiveData<List<Transaction>> = _allTransactions

    init {
        getAllTransactions()
    }

    private fun getAllTransactions() {
        viewModelScope.launch {
            val result = getAllTransactionsUseCase(Unit)
            when (result) {
                is Result.Success -> _allTransactions.value = result.data
                is Result.Error -> {
                    errorMessage.value = result.exception.message
                }
            }
        }
    }
}