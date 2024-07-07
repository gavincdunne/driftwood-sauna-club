import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import org.koin.compose.KoinContext

@Composable
fun App(root: RootComponent) {
    MaterialTheme {
        KoinContext {
            val childStack = root.childStack.subscribeAsState()

            Children(
                stack = childStack.value,
                animation = stackAnimation(slide())
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.Dashboard -> Dashboard(instance.component)
                    is RootComponent.Child.Booking -> Booking(instance.component)
                }
            }
        }
    }
}