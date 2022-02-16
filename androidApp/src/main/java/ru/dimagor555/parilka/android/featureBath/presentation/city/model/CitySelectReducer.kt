package ru.dimagor555.parilka.android.featureBath.presentation.city.model

import ru.dimagor555.mvicompose.abstraction.Reducer
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore.*

class CitySelectReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State =
        when (msg) {
            is Message.ShowBathStates -> copy(citiesState = msg.citiesStates)
        }
}