package com.elixer.paws.presentation.ui.dog_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elixer.paws.domain.model.Dog
import com.elixer.paws.interactors.dog_list.GetDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DogListViewModel @Inject constructor(
    private val getDogs: GetDogs
) : ViewModel() {

    val recipes: MutableState<List<Dog>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val allDogs = mutableListOf<Dog>()

    init {

        viewModelScope.launch {
            getDogs.execute().onEach { dataState ->
                loading.value = dataState.loading

                dataState.data?.let { list ->
                    allDogs.addAll(list)
                    recipes.value = allDogs
                }

                dataState.error?.let { error ->
                    Log.e("TAG", "newSearch: ${error}")
                }

            }.launchIn(viewModelScope)
        }
    }


}
















