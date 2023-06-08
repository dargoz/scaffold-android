package com.dargoz.dashboard.domain.usecases

import com.dargoz.core.mediator.Section
import com.dargoz.example.domain.usecases.UseCase
import com.dargoz.example.domain.entities.ExampleSection
import javax.inject.Inject

class GetWidgetUseCase @Inject constructor(): UseCase<List<Section>, Unit>() {

    override suspend fun buildUseCase(param: Unit): List<Section> {
        return listOf(
            ExampleSection(),
            ExampleSection(),
            ExampleSection()
        )
    }
}