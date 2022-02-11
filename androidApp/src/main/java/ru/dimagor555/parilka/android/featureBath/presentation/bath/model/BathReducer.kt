package ru.dimagor555.parilka.android.featureBath.presentation.bath.model

import ru.dimagor555.mvicompose.abstraction.Reducer
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore.*

class BathReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State =
        when (msg) {
            is Message.ShowBathState -> copy(bathState = msg.state)
        }
}