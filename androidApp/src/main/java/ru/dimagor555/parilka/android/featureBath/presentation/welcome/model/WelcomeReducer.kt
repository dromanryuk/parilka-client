package ru.dimagor555.parilka.android.featureBath.presentation.welcome.model

import ru.dimagor555.mvicompose.abstraction.Reducer
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore.*

class WelcomeReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State =
        when (msg) {
            is Message.ShowNearestCity -> copy(cityState = msg.city)
        }
}