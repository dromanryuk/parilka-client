package ru.dimagor555.parilka.android.featureBath.presentation.bath.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore.*

class BathActor(
    private val useCases: BathUseCases
) : Actor<State, Action, Message, SideEffect>() {

    override suspend fun onAction(action: Action) {
        when (action) {
            is Action.LoadBath -> loadBath(action.bathId)
        }
    }

    private suspend fun loadBath(bathId: Int) {
        val bathState = useCases.observeBath(bathId)?.toBathState()
        if (bathState != null) {
            sendMessage(Message.ShowBathState(bathState))
        }
    }
}