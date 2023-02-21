package com.dargoz.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dargoz.example.domain.usecases.GetOccupationListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val useCase: GetOccupationListUseCase) : ViewModel() {


    fun getData() {
        viewModelScope.launch {
            useCase("")
        }
    }


}