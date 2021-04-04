package com.elixer.paws.presentation.ui.dog_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.elixer.paws.presentation.components.DogItemCard
import com.elixer.paws.presentation.navigation.Screen
import com.elixer.paws.presentation.theme.PawsTheme
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DogListScreen(viewModel: DogListViewModel, navController: NavController) {

    val dogs = viewModel.recipes.value

    PawsTheme() {
        Box() {
            Column(modifier = Modifier.padding(bottom = 10.dp)) {
                TopAppBar(title = { Text(text = "Dog List") })
                LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                    items(dogs) { dog ->
                        DogItemCard(dog,
                            onClick = {
                                val dogJson = Gson().toJson(dog)
                                val route = Screen.DogDetail.route + "/${dogJson}"
                                navController.navigate(route)
                            }
                        )
                    }
                }
            }

            Column() {
                Spacer(Modifier.weight(1f))
                Button(onClick = { viewModel.loadMore() }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Load More")

                }
            }
        }

    }
}