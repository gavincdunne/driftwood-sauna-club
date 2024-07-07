import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
    val hasNews: Boolean = false,
    val badgeCount: Int? = null
) {
    data object Home : BottomNavItem("home", Icons.Filled.Home, Icons.Outlined.Home, "Home")
    data object Booking : BottomNavItem("booking", Icons.Filled.Search, Icons.Outlined.Search, "Booking")
    data object Community : BottomNavItem("community", Icons.Filled.Email, Icons.Outlined.Email, "Community")
}

