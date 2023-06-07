package com.dargoz.example.presentation.mappers

import com.dargoz.example.domain.entities.OccupationEntity
import com.dargoz.example.presentation.models.OccupationModel


fun OccupationEntity.toModel(): OccupationModel {
    return OccupationModel(
        code = code,
        group = group,
        position = position,
        subOccupations = subOccupations?.map { it.toModel() }
    )
}