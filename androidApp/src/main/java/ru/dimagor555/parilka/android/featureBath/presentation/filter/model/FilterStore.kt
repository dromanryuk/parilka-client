package ru.dimagor555.parilka.android.featureBath.presentation.filter.model

import ru.dimagor555.mvicompose.abstraction.Store
import ru.dimagor555.mvicompose.implementation.SimpleActionBootstrapper
import ru.dimagor555.mvicompose.implementation.StoreImpl
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.*

class FilterStore(useCases: FilterUseCases) : Store<Action, State, SideEffect> by StoreImpl(
    initialState = State(),
    actor = FilterActor(useCases),
    reducer = FilterReducer(),
    bootstrapper = SimpleActionBootstrapper()
) {
    data class State(
        val filtersState: Map<String, Set<String>> = emptyMap(),
    )

    sealed interface Action {
        object InitScreen : Action
    }

    sealed interface Message {
        data class ShowFilters(val filters: Map<String, Set<String>>) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}