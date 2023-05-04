package com.example.hackathonjudgingtracker.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.hackathonjudgingtracker.navigation.MainScreens


@Composable
fun HomeScreen(navController: NavController) {
    HomeContent(
        navigateToManualCalculationScreen = {
            navController.navigate(MainScreens.ManualCalculationScreen.route)
        },
        navigateToHackathonSelectionScreen = {
            navController.navigate(MainScreens.HackathonSelectionScreen.route)
        }
    )
}

@Composable
fun HomeContent(
    navigateToManualCalculationScreen: () -> Unit,
    navigateToHackathonSelectionScreen: () -> Unit
) {
    Column {
        Button(onClick = navigateToManualCalculationScreen) {
            Text(text = "Manually Calculate")
        }
        Button(onClick = navigateToHackathonSelectionScreen) {
            Text(text = "Select Hackathon")
        }
    }
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeContentPreview() {
    HomeContent(
        navigateToManualCalculationScreen = {},
        navigateToHackathonSelectionScreen = {}
    )
}