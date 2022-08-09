package com.bulich.misha.amberguide.data.remote.firestore_db.dto

import com.bulich.misha.amberguide.domain.model.Sight

data class SightDto(

    val name: String
)

fun SightDto.toSight(): Sight {
    return Sight(
        name = name
    )
}
