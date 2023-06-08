package com.dargoz.example.presentation.models


data class OccupationModel(
    val code : String,
    val group: String,
    val position: String?,
    val subOccupations : List<OccupationModel>?
)
