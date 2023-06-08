package com.dargoz.example.data.repositories

import android.util.Log
import com.dargoz.example.data.mappers.toEntity
import com.dargoz.example.data.mappers.toRealm
import com.dargoz.example.data.mappers.toRealmList
import com.dargoz.example.data.sources.local.ExampleLocalDataSource
import com.dargoz.example.data.sources.local.dto.OccupationDataRealm
import com.dargoz.example.domain.entities.OccupationEntity
import com.dargoz.example.domain.repositories.TestRepository
import javax.inject.Inject

open class TestRepositoryImpl @Inject constructor(
    private val exampleLocalDataSource: ExampleLocalDataSource
) :
    TestRepository {

    override suspend fun getRepository(): List<OccupationEntity> {
        val tempData = listOf(
            OccupationEntity(
                code = "01",
                group = "EMPLOYEE",
                position = null,
                subOccupations = listOf(
                    OccupationEntity(
                        code = "01",
                        group = "EMPLOYEE",
                        position = "International",
                        subOccupations = listOf(
                            OccupationEntity(
                                code = "01",
                                group = "EMPLOYEE",
                                position = "Investigator",
                                subOccupations = emptyList()
                            )
                        )
                    ),
                    OccupationEntity(
                        code = "01",
                        group = "EMPLOYEE",
                        position = "National",
                        subOccupations = listOf(
                            OccupationEntity(
                                code = "01",
                                group = "EMPLOYEE",
                                position = "Investigator",
                                subOccupations = emptyList()
                            )
                        )
                    )
                )
            ),
            OccupationEntity(
                code = "02",
                group = "STUDENT",
                position = null,
                subOccupations = listOf(
                    OccupationEntity(
                        code = "01",
                        group = "STUDENT",
                        position = "Sarjana",
                        subOccupations = null
                    ),
                    OccupationEntity(
                        code = "01",
                        group = "STUDENT",
                        position = "College Student",
                        subOccupations = null
                    )
                )
            )
        )
        exampleLocalDataSource.saveData(
            OccupationDataRealm(
                occupations = tempData.map { it.toRealm() }.toRealmList()
            )
        )
        val cache = exampleLocalDataSource.getData()
        Log.d("DRG", "get Occupation : ${cache?.occupations}")
        return cache?.occupations?.map { it.toEntity() } ?: emptyList()
    }
}