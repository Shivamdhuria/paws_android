package com.elixer.paws.presentation.ui.dog_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.elixer.paws.presentation.components.DogItemCard
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DogListScreen(viewModel: DogListViewModel, navController: NavController) {

    val dogs = viewModel.recipes.value

    Column() {

        TopAppBar(title = { Text(text = "Dog List") })
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            items(dogs) { dog ->
                DogItemCard(dog, { })
            }
        }
    }


}