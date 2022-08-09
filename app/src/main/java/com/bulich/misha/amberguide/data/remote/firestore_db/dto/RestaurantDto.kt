package com.bulich.misha.amberguide.data.remote.firestore_db.dto

import com.bulich.misha.amberguide.domain.model.Restaurant

data class RestaurantDto(

    val name: String
)

fun RestaurantDto.toRestaurant(): Restaurant {
    return Restaurant(
        name = name
    )
}
