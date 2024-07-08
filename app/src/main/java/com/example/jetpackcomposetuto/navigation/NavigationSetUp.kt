package com.example.jetpackcomposetuto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposetuto.model.Routes

@Composable
fun NavigationSetup() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.Screen1.route
    ) {
        composable(Routes.Screen1.route) { Screen1(navigationController) }
        composable(Routes.Screen2.route) { Screen2(navigationController) }
        composable(Routes.Screen3.route) { Screen3(navigationController) }
        composable(
            Routes.Screen4.route,
            arguments = listOf(navArgument("age") { type = NavType.IntType })
        ) { backStackEntry ->
            Screen4(
                navigationController = navigationController,
                age = backStackEntry.arguments?.getInt("age") ?: 0
            )
        }
        composable(
            Routes.Screen5.route,
            arguments = listOf(navArgument(
                "name"
            ) { defaultValue = "default Value" })
        ) { backStackEntry ->
            Screen5(
                navigationController = navigationController,
                name = backStackEntry.arguments?.getString("name")
            )
        }
    }
}