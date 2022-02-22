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
    bootstrapper = SimpleActionBootstrapper(Action.InitScreen)
) {
    data class State(
        val filtersState: Map<String, Set<String>> = emptyMap(),
        val markedFilters: Set<String> = emptySet()
    )

    sealed interface Action {
        object InitScreen : Action
        data class MarkFilter(val filter: String, val isMarked: Boolean) : Action
        data class SaveMarkedFilters(val markedFilters: Set<String>) : Action
    }

    sealed interface Message {
        data class ShowFilters(val filters: Map<String, Set<String>>) : Message
        data class MarkFilter(val filter: String, val isMarked: Boolean) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}