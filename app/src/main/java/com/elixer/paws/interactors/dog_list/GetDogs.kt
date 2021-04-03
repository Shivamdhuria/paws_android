package com.elixer.paws.interactors.dog_list

import android.util.Log
import com.elixer.paws.domain.data.DataState
import com.elixer.paws.domain.model.Dog
import com.elixer.paws.network.RetrofitService
import com.elixer.paws.network.model.DogDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDogs(
    private val retrofitService: RetrofitService,
//  private val entityMapper: RecipeEntityMapper,
    private val dtoMapper: DogDtoMapper
) {

    fun execute(): Flow<DataState<List<Dog>>> = flow {
        try {
            emit(DataState.loading())
            val dogs = getDogsFromNetwork()
            emit(DataState.success(dogs))
        } catch (e: Exception) {
            emit(DataState.error<List<Dog>>(e.message ?: "Unknown Error"))
        }
    }

    private suspend fun getDogsFromNetwork(): List<Dog> {
        val dogDtos = retrofitService.getDog().message
        Log.e("get dogs ", dogDtos.toString())
        return dtoMapper.toDomainList(dogDtos)
    }
}