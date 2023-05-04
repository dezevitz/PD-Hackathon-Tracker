package com.example.hackathonjudgingtracker.ui.organizer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ManualCalculationViewModel : ViewModel() {
    private val _numProjects = MutableStateFlow("")
    private val _numJudges = MutableStateFlow("")
    private val _numPassThroughs = MutableStateFlow("")
    private val _lengthEvent = MutableStateFlow("")

    private val _numProjectsPerJudge = MutableStateFlow(0)
    val numProjectsPerJudge: StateFlow<Int> = _numProjectsPerJudge

    private val _timePerProject = MutableStateFlow(0)
    val timePerProject: StateFlow<Int> = _timePerProject
    fun updateNumProjects(numProjects: String) {
        _numProjects.value = numProjects
    }

    fun updateNumJudges(numJudges: String) {
        _numJudges.value = numJudges
    }

    fun updateNumPassThroughs(numPassThroughs: String) {
        _numPassThroughs.value = numPassThroughs
    }

    fun updateLengthEvent(lengthEvent: String) {
        _lengthEvent.value = lengthEvent
    }

    fun calculateValues() {
        _numProjectsPerJudge.value =
            (_numProjects.value.toInt() * _numPassThroughs.value.toInt()) / _numJudges.value.toInt()
        _timePerProject.value = _lengthEvent.value.toInt() / _numProjectsPerJudge.value
    }
}