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
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.domain.judges.Judge
import com.example.hackathonjudgingtracker.data.domain.projects.Project


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val numProjects = homeViewModel.numProjects.collectAsState()
    val numJudges = homeViewModel.numJudges.collectAsState()
    val numPassThroughs = homeViewModel.numPassThroughs.collectAsState()
    val lengthEvent = homeViewModel.lengthEvent.collectAsState()
    val numProjectsPerJudge = homeViewModel.numProjectsPerJudge.collectAsState()
    val timePerProject = homeViewModel.timePerProject.collectAsState()

    homeViewModel.getProjects()
    val projects = homeViewModel.projectList.collectAsState()

    homeViewModel.getHackathons()
    val hackathons = homeViewModel.hackathonList.collectAsState()

    homeViewModel.getJudges()
    val judges = homeViewModel.judgeList.collectAsState()

    HomeContent(
        numProjects = numProjects.value,
        onNumProjectsChanged = { homeViewModel.updateNumProjects(it) },
        numJudges = numJudges.value,
        onNumJudgesChanged = { homeViewModel.updateNumJudges(it) },
        numPassThroughs = numPassThroughs.value,
        onNumPassThroughsChanged = { homeViewModel.updateNumPassThroughs(it) },
        lengthEvent = lengthEvent.value,
        onLengthEventChanged = { homeViewModel.updateLengthEvent(it) },
        calculateValues = { homeViewModel.calculateValues() },
        numProjectsPerJudge = numProjectsPerJudge.value.toString(),
        timePerProject = timePerProject.value.toString(),
        projects = projects.value,
        hackathons = hackathons.value,
        judges = judges.value
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    numProjects: String,
    onNumProjectsChanged: (String) -> Unit,
    numJudges: String,
    onNumJudgesChanged: (String) -> Unit,
    numPassThroughs: String,
    onNumPassThroughsChanged: (String) -> Unit,
    lengthEvent: String,
    onLengthEventChanged: (String) -> Unit,
    calculateValues: () -> Unit,
    numProjectsPerJudge: String,
    timePerProject: String,
    projects: List<Project>,
    hackathons: List<Hackathon>,
    judges: List<Judge>
) {
    Column {
        Row(modifier = modifier) {
            TextField(
                value = numProjects,
                onValueChange = onNumProjectsChanged,
                modifier = modifier,
                label = { Text(text = "Number of Projects: ") }
            )
        }
        Row(modifier = modifier) {
            TextField(
                value = numJudges,
                onValueChange = onNumJudgesChanged,
                modifier = modifier,
                label = { Text(text = "Number of Judges: ") }
            )
        }
        Row(modifier = modifier) {
            TextField(
                value = numPassThroughs,
                onValueChange = onNumPassThroughsChanged,
                modifier = modifier,
                label = { Text(text = "How Many Times Should Each Project Be Seen? ") }
            )
        }
        Row(modifier = modifier) {
            TextField(
                value = lengthEvent,
                onValueChange = onLengthEventChanged,
                modifier = modifier,
                label = { Text(text = "How Long Is Judging?(Minutes) ") }
            )
        }
        Button(onClick = { calculateValues() }) {
            Text(text = "Calculate")
        }
        Text(text = "Number of Projects Per Judge: $numProjectsPerJudge")
        Text(text = "Time each judge should spend on each table (in Minutes): $timePerProject")

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
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeContentPreview() {
    HomeContent(
        numProjects = "100",
        onNumProjectsChanged = {},
        numJudges = "10",
        onNumJudgesChanged = {},
        numPassThroughs = "2",
        onNumPassThroughsChanged = {},
        lengthEvent = "180",
        onLengthEventChanged = {},
        calculateValues = {},
        numProjectsPerJudge = "20",
        timePerProject = "9",
        projects = listOf(),
        hackathons = listOf(),
        judges = listOf()
    )
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmptyHomeContentPreview() {
    HomeContent(
        numProjects = "",
        onNumProjectsChanged = {},
        numJudges = "",
        onNumJudgesChanged = {},
        numPassThroughs = "",
        onNumPassThroughsChanged = {},
        lengthEvent = "",
        onLengthEventChanged = {},
        calculateValues = {},
        numProjectsPerJudge = "",
        timePerProject = "",
        projects = listOf(),
        hackathons = listOf(),
        judges = listOf()
    )
}