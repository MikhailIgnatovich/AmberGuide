package com.bulich.misha.amberguide.data.remote.firestore_db.dto

import com.bulich.misha.amberguide.domain.model.Hotel

data class HotelDto(

    val name: String
)

fun HotelDto.toHotel(): Hotel {
    return Hotel(
        name = name
    )
}
