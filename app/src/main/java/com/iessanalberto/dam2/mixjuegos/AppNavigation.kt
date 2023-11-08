package com.iessanalberto.dam2.mixjuegos

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.MenuScreen.route) {
        composable(route = AppScreen.MenuScreen.route) { MenuScreen(navController) }
        composable(route = AppScreen.PrimeraScreen.route ) {PrimeraScreen(navController)}
    }
}