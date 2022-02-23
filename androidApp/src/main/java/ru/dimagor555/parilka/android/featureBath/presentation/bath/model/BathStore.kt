package ru.dimagor555.parilka.android.featureBath.presentation.bath.model

import ru.dimagor555.mvicompose.abstraction.Store
import ru.dimagor555.mvicompose.implementation.StoreImpl
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state.BathContentState
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state.toBathContentState
import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer

class BathStore(
    useCases: BathUseCases
) : Store<Action, State, SideEffect> by StoreImpl(
    initialState = State(),
    actor = BathActor(useCases),
    reducer = BathReducer()
) {
    data class State(
        val bathId: Int = 0,
        val bathState: BathContentState = BathContentState()
    )

    sealed interface Action {
        data class LoadBath(val bathId: Int) : Action
    }

    sealed interface Message {
        data class ShowBathState(val state: BathContentState) : Message
    }

    sealed interface SideEffect {
        data class ShowMessage(val message: String) : SideEffect
    }
}

fun BathOffer.toBathState() = content.toBathContentState()
