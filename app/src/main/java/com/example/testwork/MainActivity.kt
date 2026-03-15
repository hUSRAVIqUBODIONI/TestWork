package com.example.testwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = NavScreens.AuthScreen.route){
                composable(route = NavScreens.AuthScreen.route){
                    NavScreens.AuthScreen
                }
                composable(route = NavScreens.ProfileScreen.route){
                    NavScreens.ProfileScreen
                }
            }
        }
    }
}


sealed class NavScreens(val route: String){
    object AuthScreen : NavScreens("auth")
    object ProfileScreen : NavScreens("profile")

}

