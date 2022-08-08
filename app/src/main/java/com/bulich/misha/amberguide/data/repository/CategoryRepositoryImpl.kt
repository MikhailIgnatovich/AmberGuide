package com.bulich.misha.amberguide.data.repository

import com.bulich.misha.amberguide.data.remote.firestore_db.CategoryFirestoreDb
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.HotelDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.RestaurantDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.SightDto
import com.bulich.misha.amberguide.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryFirestoreDb: CategoryFirestoreDb) :
    CategoryRepository {

    override suspend fun getHotels(): List<HotelDto> {
        return categoryFirestoreDb.getHotels()
    }

    override suspend fun getRestaurant(): List<RestaurantDto> {
        return categoryFirestoreDb.getRestaurants()
    }

    override suspend fun getAttractions(): List<SightDto> {
        return categoryFirestoreDb.getSights()
    }
}