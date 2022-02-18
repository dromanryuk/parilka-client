package ru.dimagor555.parilka.android.featureBath.presentation.city.model

import ru.dimagor555.mvicompose.abstraction.Store
import ru.dimagor555.mvicompose.implementation.SimpleActionBootstrapper
import ru.dimagor555.mvicompose.implementation.StoreImpl
import ru.dimagor555.parilka.android.featureBath.presentation.city.CitySelectUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore.*

class CitySelectStore(useCases: CitySelectUseCases) : Store<Action, State, SideEffect> by StoreImpl(
    initialState = State(),
    actor = CitySelectActor(useCases),
    reducer = CitySelectReducer(),
    bootstrapper = SimpleActionBootstrapper(Action.InitScreen)
) {
    data class State(
        val citiesState: List<CityState> = emptyList(),
    )

    sealed interface Action {
        object InitScreen : Action
        data class SaveCityIdInSettings(val cityId: Int) : Action
    }

    sealed interface Message {
        data class ShowBathStates(val citiesStates: List<CityState>) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}