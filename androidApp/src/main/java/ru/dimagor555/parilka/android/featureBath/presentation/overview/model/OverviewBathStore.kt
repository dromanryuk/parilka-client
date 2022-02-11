package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.mvicompose.abstraction.Store
import ru.dimagor555.mvicompose.implementation.SimpleActionBootstrapper
import ru.dimagor555.mvicompose.implementation.StoreImpl
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.BathOfferState

class OverviewBathStore(
    useCases: BathOverviewUseCases
) : Store<Action, State, SideEffect> by StoreImpl(
    initialState = State(),
    actor = BathsOverviewActor(useCases),
    reducer = BathsOverviewReducer(),
    bootstrapper = SimpleActionBootstrapper(Action.InitScreen(1))
) {
    data class State(
        val bathStates: List<BathOfferState> = emptyList(),
        val cityId: Int = 0
    )

    sealed interface Action {
        data class InitScreen(val cityId: Int) : Action
    }

    sealed interface Message {
        data class ShowBathStates(val bathStates: List<BathOfferState>) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}