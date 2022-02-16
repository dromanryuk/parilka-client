package ru.dimagor555.parilka.android.featureBath.presentation.city.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.city.CitySelectUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore.Action.*

class CitySelectActor(
    private val useCases: CitySelectUseCases
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            is InitScreen -> getCities()
        }
    }

    private suspend fun getCities() {
        val citiesState = useCases.getAllCitiesUseCase().map { it.toCityState() }
        sendMessage(Message.ShowBathStates(citiesState))
    }
}