package com.bulich.misha.amberguide.domain.repository

import com.bulich.misha.amberguide.data.remote.firestore_db.dto.HotelDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.RestaurantDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.SightDto

interface CategoryRepository {

    suspend fun getHotels(): List<HotelDto>

    suspend fun getRestaurant(): List<RestaurantDto>

    suspend fun getAttractions(): List<SightDto>

}