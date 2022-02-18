package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.mvicompose.abstraction.Reducer
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.Message
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.State

class BathsOverviewReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State =
        when (msg) {
            is Message.ShowBathStates -> copy(bathStates = msg.bathStates)
            is Message.SetNearestCity -> copy(cityId = msg.cityId, cityName = msg.cityName)
        }
}