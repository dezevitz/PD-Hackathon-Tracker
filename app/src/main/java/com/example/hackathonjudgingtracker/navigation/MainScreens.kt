package com.example.hackathonjudgingtracker.navigation

sealed class MainScreens(val route: String) {
    object HomeScreen : MainScreens("main_screen")
    object ManualCalculationScreen : MainScreens("manual_calculation_screen")
    object HackathonSelectionScreen : MainScreens("hackathon_section_screen")
    object ProjectScreen : MainScreens("project_screen")
}
