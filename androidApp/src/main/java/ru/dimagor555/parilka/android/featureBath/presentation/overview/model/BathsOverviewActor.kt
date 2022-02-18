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
            Action.InitScreen -> initScreen()
        }
    }

    private suspend fun initScreen() {
        loadUserCity()
        loadBathOffers()
    }

    private suspend fun loadUserCity() {
        val userCity = useCases.getUserCity()
        sendMessage(Message.SetUserCityName(userCity.name))
    }

    private suspend fun loadBathOffers() {
        val bathState = useCases.getBathOffers().map { it.toBathOfferState() }
        sendMessage(Message.ShowBathStates(bathState))
    }
}