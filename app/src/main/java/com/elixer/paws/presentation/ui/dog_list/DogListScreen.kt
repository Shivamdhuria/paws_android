package com.elixer.paws.presentation.ui.dog_list

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.elixer.paws.presentation.navigation.Screen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DogListScreen(viewModel: DogListViewModel, navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "Dog List Screen!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h3
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = {
            val route = Screen.DogDetail.route
            navController.navigate(route)
            Log.e("poop", "button lciked")
        }) {
            Text("I'm a Compose Button")
        }
    }


}