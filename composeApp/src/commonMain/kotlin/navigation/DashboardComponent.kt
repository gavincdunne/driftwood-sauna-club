package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DashboardComponent(
    componentContext: ComponentContext,
    private val onNavigateToBooking: (String) -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.ClickButton -> onNavigateToBooking(text.value)
            is DashboardEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }
}