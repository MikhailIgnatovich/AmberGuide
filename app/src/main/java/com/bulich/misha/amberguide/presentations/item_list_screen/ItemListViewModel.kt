package com.bulich.misha.amberguide.presentations.item_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.amberguide.common.Constants
import com.bulich.misha.amberguide.common.Resource
import com.bulich.misha.amberguide.domain.use_case.GetHotelsUseCase
import com.bulich.misha.amberguide.domain.use_case.GetRestaurantsUseCase
import com.bulich.misha.amberguide.domain.use_case.GetSightsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val getHotelsUseCase: GetHotelsUseCase,
    private val getRestaurantsUseCase: GetRestaurantsUseCase,
    private val getSightsUseCase: GetSightsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ItemListState())
    val state: State<ItemListState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CATEGORY)?.let { category ->
            getList(category)
        }
    }


    private fun getList(category: String) {
        when (category) {
            "Гостиницы" -> {
                getHotelList()
            }
            "Рестораны" -> {
                getRestaurantsList()
            }
            "Интересное" -> {
                getSightsList()
            }
        }
    }

    private fun getHotelList() {
        getHotelsUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = ItemListState(hotels = it.data)
                }
                is Resource.Error -> {
                    _state.value = ItemListState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = ItemListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getRestaurantsList() {
        getRestaurantsUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = ItemListState(restaurants = it.data)
                }
                is Resource.Error -> {
                    _state.value = ItemListState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = ItemListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSightsList() {
        getSightsUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = ItemListState(sights = it.data)
                }
                is Resource.Error -> {
                    _state.value = ItemListState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = ItemListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}