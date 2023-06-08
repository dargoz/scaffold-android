package com.dargoz.example.di

import com.dargoz.example.data.sources.local.ExampleLocalDataSource
import com.dargoz.example.data.sources.local.ExampleLocalDataSourceImpl
import com.dargoz.example.data.repositories.TestRepositoryImpl
import com.dargoz.example.domain.repositories.TestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {

    @Binds
    abstract fun provideTestRepository(testRepository: TestRepositoryImpl): TestRepository

    @Binds
    abstract fun provideAuthLocalDataSource(exampleLocalDataSource: ExampleLocalDataSourceImpl): ExampleLocalDataSource

}