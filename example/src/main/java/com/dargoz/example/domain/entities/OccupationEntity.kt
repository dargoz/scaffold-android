package com.dargoz.example.domain.entities


class OccupationEntity(
    val code : String,
    val group: String,
    val position: String?,
    val subOccupations : List<OccupationEntity>?
) {

    override fun toString(): String {
        return "OccupationEntity(code='$code', group='$group', position=$position, subOccupations=$subOccupations)"
    }
}