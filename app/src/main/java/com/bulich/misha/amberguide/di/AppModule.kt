package com.bulich.misha.amberguide.di

import com.bulich.misha.amberguide.data.remote.firestore_db.CategoryFirestoreDb
import com.bulich.misha.amberguide.data.repository.CategoryRepositoryImpl
import com.bulich.misha.amberguide.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryFirestoreDb: CategoryFirestoreDb): CategoryRepository {
        return CategoryRepositoryImpl(categoryFirestoreDb)
    }
}