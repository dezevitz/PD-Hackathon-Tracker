import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hackathonjudgingtracker.data.domain.hackathons.Hackathon
import com.example.hackathonjudgingtracker.navigation.MainScreens

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HackathonSelectionScreen(
    navController: NavHostController,
    viewModel: HackathonSelectionViewModel = HackathonSelectionViewModel()
) {
    // TODO Hoist all these values (currently hoisting them causes recomp)
    val hackathonListState by viewModel.hackathonUiState.collectAsState()

    val onHackathonSelected: (Hackathon) -> Unit = { // TODO Pass the hackathon as a navarg
        navController.navigate(MainScreens.ProjectScreen.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Select a Hackathon") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (hackathonListState.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    strokeWidth = 4.dp,
                    modifier = Modifier.size(75.dp),
                )
            }
        }
        LazyColumn {
            items(hackathonListState.hackathonList) { hackathon ->
                ListItem(
                    text = { Text(hackathon.fields.Name) },
                    modifier = Modifier
                        .clickable { onHackathonSelected(hackathon) }
                        .border(1.dp, Color.Black),
                )
            }
        }
    }
}