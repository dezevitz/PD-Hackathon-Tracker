package com.example.hackathonjudgingtracker.ui.organizer

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ManualCalculationScreen(
    manualCalculationViewModel: ManualCalculationViewModel = ManualCalculationViewModel()
) {
    val numProjects = manualCalculationViewModel.numProjects.collectAsState()
    val numJudges = manualCalculationViewModel.numJudges.collectAsState()
    val numPassThroughs = manualCalculationViewModel.numPassThroughs.collectAsState()
    val lengthEvent = manualCalculationViewModel.lengthEvent.collectAsState()
    val numProjectsPerJudge = manualCalculationViewModel.numProjectsPerJudge.collectAsState()
    val timePerProject = manualCalculationViewModel.timePerProject.collectAsState()

    CalculateValuesContent(
        numProjects = numProjects.value,
        onNumProjectsChanged = { manualCalculationViewModel.updateNumProjects(it) },
        numJudges = numJudges.value,
        onNumJudgesChanged = { manualCalculationViewModel.updateNumJudges(it) },
        numPassThroughs = numPassThroughs.value,
        onNumPassThroughsChanged = { manualCalculationViewModel.updateNumPassThroughs(it) },
        lengthEvent = lengthEvent.value,
        onLengthEventChanged = { manualCalculationViewModel.updateLengthEvent(it) },
        calculateValues = { manualCalculationViewModel.calculateValues() },
        numProjectsPerJudge = numProjectsPerJudge.value.toString(),
        timePerProject = timePerProject.value.toString(),
    )
}

@Composable
fun CalculateValuesContent(
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
    }
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CalculateValuesContentPreview() {
    CalculateValuesContent(
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
        timePerProject = "9"
    )
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmptyCalculateValuesContentPreview() {
    CalculateValuesContent(
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
        timePerProject = ""
    )
}