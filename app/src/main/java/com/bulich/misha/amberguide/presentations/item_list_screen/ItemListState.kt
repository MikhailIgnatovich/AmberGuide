package com.bulich.misha.amberguide.presentations.item_list_screen

import com.bulich.misha.amberguide.domain.model.Hotel
import com.bulich.misha.amberguide.domain.model.Restaurant
import com.bulich.misha.amberguide.domain.model.Sight

data class ItemListState(
    val hotels: List<Hotel>? = null,
    val restaurants: List<Restaurant>? = null,
    val sights: List<Sight>? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
