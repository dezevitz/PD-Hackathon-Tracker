package com.example.hackathonjudgingtracker.ui.organizer

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ManualCalculationScreen(
    manualCalculationViewModel: ManualCalculationViewModel = ManualCalculationViewModel()
) {
    val numProjectsPerJudge = manualCalculationViewModel.numProjectsPerJudge.collectAsState()
    val timePerProject = manualCalculationViewModel.timePerProject.collectAsState()

    CalculateValuesContent(
        onNumProjectsChanged = { manualCalculationViewModel.updateNumProjects(it) },
        onNumJudgesChanged = { manualCalculationViewModel.updateNumJudges(it) },
        onNumPassThroughChanged = { manualCalculationViewModel.updateNumPassThroughs(it) },
        onLengthEventChanged = { manualCalculationViewModel.updateLengthEvent(it) },
        calculateValues = { manualCalculationViewModel.calculateValues() },
        numProjectsPerJudge = numProjectsPerJudge.value.toString(),
        timePerProject = timePerProject.value.toString(),
    )
}

@Composable
fun CalculateValuesContent(
    modifier: Modifier = Modifier,
    onNumProjectsChanged: (String) -> Unit,
    onNumJudgesChanged: (String) -> Unit,
    onNumPassThroughChanged: (String) -> Unit,
    onLengthEventChanged: (String) -> Unit,
    calculateValues: () -> Unit,
    numProjectsPerJudge: String,
    timePerProject: String,
) {
    Column(modifier) {
        HackathonTextField(
            onValueChange = onNumProjectsChanged,
            label = "Number of Projects: "
        )
        HackathonTextField(
            onValueChange = onNumJudgesChanged,
            label = "Number of Judges: "
        )
        HackathonTextField(
            onValueChange = onNumPassThroughChanged,
            label = "How Many Times Should Each Project Be Seen? "
        )
        HackathonTextField(
            onValueChange = onLengthEventChanged,
            label = "How Long Is Judging?(Minutes) "
        )
        Button(onClick = { calculateValues() }) {
            Text(text = "Calculate")
        }
        Text(text = "Number of Projects Per Judge: $numProjectsPerJudge")
        Text(text = "Time each judge should spend on each table (in Minutes): $timePerProject")
    }
}

@Composable
private fun HackathonTextField(
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    var localValue by remember {
        mutableStateOf("")
    }
    TextField(
        value = localValue,
        onValueChange = {
            onValueChange(it)
            localValue = it
        },
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CalculateValuesContentPreview() {
    CalculateValuesContent(
        onNumProjectsChanged = {},
        onNumJudgesChanged = {},
        onNumPassThroughChanged = {},
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
        onNumProjectsChanged = {},
        onNumJudgesChanged = {},
        onNumPassThroughChanged = {},
        onLengthEventChanged = {},
        calculateValues = {},
        numProjectsPerJudge = "",
        timePerProject = ""
    )
}