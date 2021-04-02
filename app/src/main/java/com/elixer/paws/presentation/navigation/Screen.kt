package com.elixer.paws.presentation.navigation

sealed class Screen(val route: String, ){

    object DogList: Screen("dogList")

    object DogDetail: Screen("dogDetail")
}