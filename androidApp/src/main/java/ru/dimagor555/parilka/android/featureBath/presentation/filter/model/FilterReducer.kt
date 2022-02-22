package ru.dimagor555.parilka.android.featureBath.presentation.filter.model

import ru.dimagor555.mvicompose.abstraction.Reducer
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.*

class FilterReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State =
        when (msg) {
            is Message.ShowFilters -> copy(filtersState = msg.filters)
            is Message.MarkFilter -> copy(
                markedFilters = if (msg.isMarked) markedFilters.plus(msg.filter)
                else markedFilters.minus(msg.filter)
            )
        }
}