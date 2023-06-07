package com.dargoz.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dargoz.example.domain.usecases.GetOccupationListUseCase
import com.dargoz.example.presentation.mappers.toModel
import com.dargoz.example.presentation.models.OccupationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val useCase: GetOccupationListUseCase) : ViewModel() {


    val state : SharedFlow<Result<List<OccupationModel>>> get() = _state
    private val _state : MutableSharedFlow<Result<List<OccupationModel>>> = MutableSharedFlow()

    fun getData() {
        viewModelScope.launch {
            val result = useCase("")
            _state.emit(result.map {
                it.map { occupationEntity ->
                    occupationEntity.toModel()
                }
            })
        }
    }


}