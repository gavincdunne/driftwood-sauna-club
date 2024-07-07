package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(componentContext: ComponentContext) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Dashboard,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(config: Configuration, context: ComponentContext): Child =
        when (config) {
            Configuration.Dashboard -> Child.Dashboard(
                DashboardComponent(
                    componentContext = context,
                    onNavigateToBooking = { text ->
                        navigation.pushNew(Configuration.Booking(text))
                    }
                )
            )

            is Configuration.Booking -> Child.Booking(
                BookingComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }

    sealed class Child {
        data class Dashboard(val component: DashboardComponent) : Child()
        data class Booking(val component: BookingComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object Dashboard : Configuration()

        @Serializable
        data class Booking(val text: String) : Configuration()
    }
}