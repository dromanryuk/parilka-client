package ru.dimagor555.parilka.android.featureBath.presentation.welcome.model

import ru.dimagor555.mvicompose.abstraction.Store
import ru.dimagor555.mvicompose.implementation.SimpleActionBootstrapper
import ru.dimagor555.mvicompose.implementation.StoreImpl
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.WelcomeUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore.*

class WelcomeStore(useCases: WelcomeUseCases) : Store<Action, State, SideEffect> by StoreImpl(
    initialState = State(),
    actor = WelcomeActor(useCases),
    reducer = WelcomeReducer(),
    bootstrapper = SimpleActionBootstrapper(Action.InitScreen)
) {
    data class State(
        val cityState: String = "",
        val navigateToOverviewScreen: Boolean = false,
        val navigateToCityScreen: Boolean = false,
    )

    sealed interface Action {
        object InitScreen : Action
        object SetCitySettings : Action
    }

    sealed interface Message {
        data class ShowNearestCity(val city: String) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}