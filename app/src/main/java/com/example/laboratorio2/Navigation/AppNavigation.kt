package com.example.laboratorio2.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio2.Screens.FirstScreen
import com.example.laboratorio2.Screens.SecondScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstSreen.route ){
        composable(
            route = AppScreens.FirstSreen.route
        ){
            FirstScreen(navController)
        }
        composable(
            route = AppScreens.SeconSreen.route+ "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ){
            SecondScreen(navController, it.arguments?.getString("text"))
        }
    }
}