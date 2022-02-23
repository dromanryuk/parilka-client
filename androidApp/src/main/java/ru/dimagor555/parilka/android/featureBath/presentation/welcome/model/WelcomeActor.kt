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
            InitScreen -> getNearestCity()
            Action.SetCitySettings -> setCitySettings()
        }
    }

    private suspend fun getNearestCity() {
        val cityState = useCases.findNearestCityUseCase() ?: return
        sendMessage(Message.ShowNearestCity(cityState.name))
    }

    private suspend fun setCitySettings() {
        val nearestCity = useCases.findNearestCityUseCase() ?: return
        useCases.setCitySettingsUseCase(nearestCity.id)
    }
}