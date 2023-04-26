package com.example.hackathonjudgingtracker

import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackathonjudgingtracker.navigation.Screen
import com.example.hackathonjudgingtracker.ui.home.HomeScreen
import com.example.hackathonjudgingtracker.ui.organizer.HackathonSelectionScreen
import com.example.hackathonjudgingtracker.ui.organizer.ManualCalculationScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ManualCalculationScreen.route) {
            ManualCalculationScreen()
        }
        composable(route = Screen.HackathonSelectionScreen.route) {
            HackathonSelectionScreen()
        }
    }
}