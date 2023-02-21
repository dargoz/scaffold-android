package com.dargoz.example.data.sources.local

import com.dargoz.example.data.sources.local.dto.OccupationDataRealm

interface ExampleLocalDataSource {

    suspend fun saveData(occupationDataRealm: OccupationDataRealm)

    suspend fun getData() : OccupationDataRealm?

}