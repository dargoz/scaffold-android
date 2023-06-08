package com.dargoz.example.domain.usecases

import android.util.Log
import com.dargoz.example.domain.entities.OccupationEntity
import com.dargoz.example.domain.repositories.TestRepository
import javax.inject.Inject

class GetOccupationListUseCase @Inject constructor(private val testRepository: TestRepository) :
    UseCase<List<OccupationEntity>, String>() {

    override suspend fun buildUseCase(param: String): List<OccupationEntity> {
        val result = testRepository.getRepository()
        Log.d("DRG", "use case result : $result")
        return result
    }
}