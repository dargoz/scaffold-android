package com.dargoz.example.domain.repositories

import com.dargoz.example.domain.entities.OccupationEntity


interface TestRepository {

    suspend fun getRepository(): List<OccupationEntity>

}