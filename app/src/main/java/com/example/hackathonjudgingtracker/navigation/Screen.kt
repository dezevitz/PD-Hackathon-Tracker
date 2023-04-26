package com.example.hackathonjudgingtracker.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("main_screen")
    object ManualCalculationScreen : Screen("manual_calculation_screen")
    object HackathonSelectionScreen : Screen("hackathon_section_screen")
}
