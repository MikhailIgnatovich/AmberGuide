package com.bulich.misha.amberguide.domain.use_case

import com.bulich.misha.amberguide.common.Resource
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.toRestaurant
import com.bulich.misha.amberguide.domain.model.Restaurant
import com.bulich.misha.amberguide.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRestaurantsUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    operator fun invoke(): Flow<Resource<List<Restaurant>>> = flow {
        try {
            emit(Resource.Loading<List<Restaurant>>())
            val restaurants = categoryRepository.getRestaurant().map { it.toRestaurant() }
            if (restaurants.isNotEmpty()) {
                emit(Resource.Success<List<Restaurant>>(restaurants))
            } else {
                emit(Resource.Error<List<Restaurant>>("Не удалось связаться с сервером. Проверьте свое подключение к Интернету"))
            }
        } catch (e: Exception) {
            emit(
                Resource.Error<List<Restaurant>>(
                    e.localizedMessage
                        ?: "Не удалось связаться с сервером. Проверьте свое подключение к Интернету"
                )
            )
        }
    }
}