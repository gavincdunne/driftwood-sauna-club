package navigation

sealed interface DashboardEvent {
    data object ClickButton: DashboardEvent
    data class UpdateText(val text: String): DashboardEvent
}