package di

import CheckoutViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::CheckoutViewModel)
}