package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.toBathOfferState

class BathsOverviewActor(
    private val useCases: BathOverviewUseCases
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            is Action.InitScreen -> getPasswords(action.cityId)
        }
    }

    private suspend fun getPasswords(cityId: Int) {
        val bathState = useCases.getBaths(cityId).map { it.toBathOfferState() }
        sendMessage(Message.ShowBathStates(bathState))
    }
}