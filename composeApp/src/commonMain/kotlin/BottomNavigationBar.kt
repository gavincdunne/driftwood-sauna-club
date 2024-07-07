import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Booking,
        BottomNavItem.Community
    )

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                onClick = {
                    // appNavigation.navigateTo(item.route)
                },
                label = {
                    Text(text = item.label)
                },
                selected = false,
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == 0) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.label
                        )
                    }
                }
            )
        }
    }
}