package com.example.hackathonjudgingtracker.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.domain.judges.Judge
import com.example.hackathonjudgingtracker.data.domain.projects.Project
import com.example.hackathonjudgingtracker.navigation.Screen


@Composable
fun HomeScreen(navController: NavController) {
    HomeContent(
        navigateToManualCalculationScreen = {
            navController.navigate(Screen.ManualCalculationScreen.route)
        },
        navigateToHackathonSelectionScreen = {
            navController.navigate(Screen.HackathonSelectionScreen.route)
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