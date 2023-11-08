package com.iessanalberto.dam2.mixjuegos

sealed class AppScreen (val route: String){
    object MenuScreen: AppScreen(route = "MenuScreen")
    object PrimeraScreen: AppScreen(route="PrimeraScreen")
}
