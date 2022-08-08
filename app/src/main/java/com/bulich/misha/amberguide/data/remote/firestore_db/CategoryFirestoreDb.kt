package com.bulich.misha.amberguide.data.remote.firestore_db

import com.bulich.misha.amberguide.common.Constants
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.HotelDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.RestaurantDto
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.SightDto
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await



class CategoryFirestoreDb  {

    private val db = Firebase.firestore

    suspend fun getHotels(): List<HotelDto> {
        return try {
            db.collection(Constants.HOTELS_COLLECTION).get().await().toObjects(HotelDto::class.java)
        } catch (e: Exception) {
            emptyList<HotelDto>()
        }
    }

    suspend fun getRestaurants(): List<RestaurantDto> {
        return try {
            db.collection(Constants.RESTAURANTS_COLLECTION).get().await()
                .toObjects(RestaurantDto::class.java)
        } catch (e: Exception) {
            emptyList<RestaurantDto>()
        }
    }

    suspend fun getSights(): List<SightDto> {
        return try {
            db.collection(Constants.SIGHTS_COLLECTION).get().await().toObjects(SightDto::class.java)
        } catch (e: Exception) {
            emptyList<SightDto>()
        }
    }
}