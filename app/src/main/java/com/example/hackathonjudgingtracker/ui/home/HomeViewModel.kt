package com.example.hackathonjudgingtracker.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.domain.judges.Judge
import com.example.hackathonjudgingtracker.data.domain.projects.Project
import com.example.hackathonjudgingtracker.data.network.AirtableNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _numProjects = MutableStateFlow("")
    val numProjects: StateFlow<String> = _numProjects

    private val _numJudges = MutableStateFlow("")
    val numJudges: StateFlow<String> = _numJudges

    private val _numPassThroughs = MutableStateFlow("")
    val numPassThroughs: StateFlow<String> = _numPassThroughs

    private val _lengthEvent = MutableStateFlow("")
    val lengthEvent: StateFlow<String> = _lengthEvent

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
            (numProjects.value.toInt() * numPassThroughs.value.toInt()) / numJudges.value.toInt()
        _timePerProject.value = lengthEvent.value.toInt() / numProjectsPerJudge.value
    }

    private val _projectsList = MutableStateFlow(listOf<Project>())
    val projectList: StateFlow<List<Project>> = _projectsList

    private val _hackathonList = MutableStateFlow(listOf<Hackathon>())
    val hackathonList: StateFlow<List<Hackathon>> = _hackathonList

    private val _judgesList = MutableStateFlow(listOf<Judge>())
    val judgeList: StateFlow<List<Judge>> = _judgesList

    fun getProjects() {
        viewModelScope.launch {
            _projectsList.value = AirtableNetwork.retrofit.getProjects().records
            Log.d("hvm projects", projectList.value.toString())
        }
    }

    fun getHackathons() {
        viewModelScope.launch {
            _hackathonList.value = AirtableNetwork.retrofit.getHackathon().records
            Log.d("hvm hackathons", hackathonList.value.toString())
        }
    }

    fun getJudges() {
        viewModelScope.launch {
            _judgesList.value = AirtableNetwork.retrofit.getJudges().records
            Log.d("hvm judge", judgeList.value.toString())
        }
    }

}