package com.example.testwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testwork.presentation.Auth.AuthScreen
import com.example.testwork.presentation.Profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val signed : Boolean?  = null
            var start = NavScreens.AuthScreen.route
            if(signed != null){
                start = NavScreens.ProfileScreen.route
            }
            Scaffold(){ padding ->
                NavHost(navController = navController, startDestination = start) {
                    composable(route = NavScreens.AuthScreen.route) {
                        AuthScreen(padding,navController)
                    }
                    composable(route = NavScreens.ProfileScreen.route) {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}


sealed class NavScreens(val route: String){
    object AuthScreen : NavScreens("auth")
    object ProfileScreen : NavScreens("profile")

}

