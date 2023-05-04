package com.example.hackathonjudgingtracker.navigation

import HackathonSelectionScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackathonjudgingtracker.ui.home.HomeScreen
import com.example.hackathonjudgingtracker.ui.organizer.ManualCalculationScreen
import com.example.hackathonjudgingtracker.ui.organizer.ProjectScreen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = MainScreens.HomeScreen.route) {
        composable(route = MainScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = MainScreens.ManualCalculationScreen.route) {
            ManualCalculationScreen()
        }
        composable(route = MainScreens.HackathonSelectionScreen.route) {
            HackathonSelectionScreen(
                navController = navController
            )
        }
        composable(route = MainScreens.ProjectScreen.route) {
            ProjectScreen(navController = navController)
        }
    }
}