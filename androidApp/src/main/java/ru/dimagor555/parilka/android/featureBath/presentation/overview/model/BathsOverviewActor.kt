package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.overview.BathOverviewUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.toBathOfferState

class BathsOverviewActor(
    private val useCases: BathOverviewUseCases
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            Action.InitScreen -> getBaths()
        }
    }

    private suspend fun getBaths() {
        val cityId = useCases.getCityId("cityId") ?: return
        val city = useCases.getCityById(cityId) ?: return
        sendMessage(Message.SetNearestCity(cityId, city.name))
        val bathState = useCases.getBaths(cityId).map { it.toBathOfferState() }
        sendMessage(Message.ShowBathStates(bathState))
    }
}