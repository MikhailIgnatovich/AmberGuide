package com.bulich.misha.amberguide.domain.use_case

import com.bulich.misha.amberguide.common.Resource
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.toHotel
import com.bulich.misha.amberguide.domain.model.Hotel
import com.bulich.misha.amberguide.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    operator fun invoke(): Flow<Resource<List<Hotel>>> = flow {
        try {
            emit(Resource.Loading<List<Hotel>>())
            val hotels = categoryRepository.getHotels().map { it.toHotel() }
            if (hotels.isNotEmpty()) {
                emit(Resource.Success<List<Hotel>>(hotels))
            } else {
                emit(Resource.Error<List<Hotel>>("Не удалось связаться с сервером. Проверьте свое подключение к Интернету"))
            }
        } catch (e: Exception) {
            emit(
                Resource.Error<List<Hotel>>(
                    e.localizedMessage
                        ?: "Не удалось связаться с сервером. Проверьте свое подключение к Интернету"
                )
            )
        }
    }
}