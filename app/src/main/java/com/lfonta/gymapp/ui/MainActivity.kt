package com.lfonta.gymapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lfonta.gymapp.ui.navigation.AppNavGraph
import com.lfonta.gymapp.ui.navigation.AppScreen
import com.lfonta.gymapp.ui.theme.GymAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Aca tendria que chequear que pantalla abrir
                    val startDestination = AppScreen.Home.route

                    GymApp(startDestination = startDestination)
                }
            }
        }
    }
}

@Composable
fun GymApp(startDestination: String) {
    val navController = rememberNavController()

    AppNavGraph(navController = navController, startDestination =  startDestination)
}

