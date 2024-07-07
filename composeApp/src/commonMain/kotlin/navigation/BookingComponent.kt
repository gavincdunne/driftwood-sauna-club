package navigation

import com.arkivanov.decompose.ComponentContext

class BookingComponent(
    val text: String,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    fun goBack() = onGoBack()
}