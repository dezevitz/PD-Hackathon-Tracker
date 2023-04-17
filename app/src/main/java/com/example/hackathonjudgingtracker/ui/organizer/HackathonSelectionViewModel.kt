package com.example.hackathonjudgingtracker.ui.organizer

import android.app.GameState
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.domain.judges.Judge
import com.example.hackathonjudgingtracker.data.domain.projects.Project
import com.example.hackathonjudgingtracker.data.network.AirtableNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HackathonUiState (
    var projectList: List<Project> = listOf(),
    var hackathonList: List<Hackathon> = listOf(),
    var judgeList: List<Judge> = listOf()
)

class HackathonSelectionViewModel : ViewModel() {

    private val _hackathonUiState = MutableStateFlow(HackathonUiState())
    val hackathonUiState: StateFlow<HackathonUiState> = _hackathonUiState.asStateFlow()

    fun getValues() {
        viewModelScope.launch {
            _hackathonUiState.value = HackathonUiState(
                projectList = AirtableNetwork.retrofit.getProjects().records,
                hackathonList = AirtableNetwork.retrofit.getHackathon().records,
                judgeList = AirtableNetwork.retrofit.getJudges().records
                )
            Log.d("hvm projects", _hackathonUiState.value.projectList.toString())
            Log.d("hvm hackathons",  _hackathonUiState.value.hackathonList.toString())
            Log.d("hvm judge",  _hackathonUiState.value.judgeList.toString())
        }
    }
}