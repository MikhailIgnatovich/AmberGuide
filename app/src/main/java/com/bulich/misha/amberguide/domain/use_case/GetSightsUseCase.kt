package com.bulich.misha.amberguide.domain.use_case

import com.bulich.misha.amberguide.common.Resource
import com.bulich.misha.amberguide.data.remote.firestore_db.dto.toSight
import com.bulich.misha.amberguide.domain.model.Sight
import com.bulich.misha.amberguide.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSightsUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    operator fun invoke(): Flow<Resource<List<Sight>>> = flow {
        try {
            emit(Resource.Loading<List<Sight>>())
            val sights = categoryRepository.getAttractions().map { it.toSight() }
            if (sights.isNotEmpty()) {
                emit(Resource.Success<List<Sight>>(sights))
            } else {
                emit(Resource.Error<List<Sight>>("Не удалось связаться с сервером. Проверьте свое подключение к Интернету"))
            }
        } catch (e: Exception) {
            emit(
                Resource.Error<List<Sight>>(
                    e.localizedMessage
                        ?: "Не удалось связаться с сервером. Проверьте свое подключение к Интернету"
                )
            )
        }
    }
}