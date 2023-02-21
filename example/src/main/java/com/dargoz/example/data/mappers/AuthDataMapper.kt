package com.dargoz.example.data.mappers


import com.dargoz.example.data.sources.local.dto.OccupationRealm
import com.dargoz.example.domain.entities.OccupationEntity
import io.realm.RealmList

fun OccupationEntity.toRealm() : OccupationRealm {
    return OccupationRealm(
        code = code,
        group = group,
        position = position,
        subOccupations = subOccupations?.map { it.toRealm() }?.toRealmList()
    )
}

fun OccupationRealm.toEntity() : OccupationEntity {
    return OccupationEntity(
        code = code,
        group = group,
        position = position,
        subOccupations = subOccupations?.map { it.toEntity() }?.toList()
    )
}


fun <T> List<T>.toRealmList(): RealmList<T> {
    return RealmList<T>().also {
        result -> forEach { result.add(it) }
    }
}