package com.lfonta.gymapp.ui.navigation

sealed class AppScreen(val route: String) {

    // Pantallas de auth
    object Login : AppScreen("login_screen")
    object Register : AppScreen("register_screen")

    // Pantalla de carga inicial
    object Splash : AppScreen("splash_screen")

    // Pantallas principales de la app
    object Home : AppScreen("home_screen")
    object Routines : AppScreen("routines_screen")
    object Recipes : AppScreen("recipes_screen")
    object Profile : AppScreen("profile_screen")
    object Timer : AppScreen("timer_screen")
}