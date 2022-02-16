package ru.dimagor555.parilka.android.featureBath.presentation.welcome.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.WelcomeUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore.Action.InitScreen

class WelcomeActor(
    private val useCases: WelcomeUseCases
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
             is InitScreen -> getNearestCity()
        }
    }

    private suspend fun getNearestCity() {
        val cityState = useCases.findNearestCityUseCase()
        cityState?.let { sendMessage(Message.ShowNearestCity(cityState.name)) }
    }
}