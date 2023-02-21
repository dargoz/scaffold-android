package com.dargoz.example.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<Return, Param> {

    suspend operator fun invoke(param: Param): Result<Return> = withContext(Dispatchers.IO) {
        try {
            Result.success(buildUseCase(param))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    abstract suspend fun buildUseCase(param: Param): Return


}