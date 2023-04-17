package com.example.hackathonjudgingtracker.ui.organizer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.domain.judges.Judge
import com.example.hackathonjudgingtracker.data.domain.projects.Project

@Composable
fun HackathonSelectionScreen(
    hackathonSelectionViewModel: HackathonSelectionViewModel = HackathonSelectionViewModel()
) {
    hackathonSelectionViewModel.getValues()

    val hackathonUiState = hackathonSelectionViewModel.hackathonUiState.collectAsState()

    HackathonSelectionContent(
        projects = hackathonUiState.value.projectList,
        hackathons = hackathonUiState.value.hackathonList,
        judges = hackathonUiState.value.judgeList
    )
}

@Composable
fun HackathonSelectionContent(
    projects: List<Project>,
    hackathons: List<Hackathon>,
    judges: List<Judge>
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.LightGray,
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Project List",
                fontSize = 30.sp,
                fontWeight = W400
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                projects.forEach { project ->
                    Text(text = project.fields.Name)
                }
            }
            Text(
                text = "Hackathon List",
                fontSize = 30.sp,
                fontWeight = W400
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                hackathons.forEach { hackathon ->
                    Text(text = hackathon.fields.Name)
                }
            }
            Text(
                text = "Judge List",
                fontSize = 30.sp,
                fontWeight = W400
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                judges.forEach { judge ->
                    Text(text = judge.fields.Name)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HackathonSelectionScreenPreview() {
    HackathonSelectionContent(
        projects = listOf(),
        hackathons = listOf(),
        judges = listOf(),
    )
}