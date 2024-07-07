import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import org.koin.compose.koinInject


@Composable
fun Main() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {}
}