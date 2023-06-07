package com.dargoz.dashboard.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dargoz.core.mediator.Section
import com.dargoz.core.plugin.FeatureModule
import com.dargoz.dashboard.domain.usecases.GetWidgetUseCase
import com.dargoz.dashboard.presentation.mappers.toModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val getWidgetUseCase: GetWidgetUseCase) : ViewModel() {

    val state : SharedFlow<Result<List<FeatureModule>>> get() = _state
    private val _state : MutableSharedFlow<Result<List<FeatureModule>>> = MutableSharedFlow()

    fun getWidgetList() {
        viewModelScope.launch {
            _state.emit(getWidgetUseCase(Unit).map {
                it.map { section -> section.toModule() }
            })
        }
    }

}