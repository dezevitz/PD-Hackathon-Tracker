import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.data.network.AirtableNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HackathonUiState (
    var isLoading: Boolean = true,
    var hackathonList: List<Hackathon> = listOf()
)

class HackathonSelectionViewModel : ViewModel() {

    private val _hackathonUiState = MutableStateFlow(HackathonUiState())
    val hackathonUiState: StateFlow<HackathonUiState> = _hackathonUiState.asStateFlow()

    init {
        viewModelScope.launch {
            val hackathonList = AirtableNetwork.retrofit.getHackathon().records
            _hackathonUiState.value = _hackathonUiState.value.copy(
                isLoading = false,
                hackathonList = hackathonList
            )
            Log.d("Hackathons", hackathonList.toString())
        }
    }
}
