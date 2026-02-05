package com.lfonta.gymapp.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lfonta.gymapp.ui.components.Chronometer

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost (
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = AppScreen.Login.route) {

        }
        composable(route = AppScreen.Register.route) {

        }
        composable(route = AppScreen.Splash.route) {

        }
        composable(route = AppScreen.Home.route) {
            HomeScreen()
        }
        composable(route = AppScreen.Routines.route) {

        }
        composable(route = AppScreen.Recipes.route) {

        }
        composable(route = AppScreen.Profile.route) {

        }
        composable(route = AppScreen.Timer.route) {
            Chronometer()
        }
    }
}

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {
    Text(text = "Home screen")
}