package ru.dimagor555.parilka.android.featureBath.presentation.filter

import ru.dimagor555.mvicompose.android.MviViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.*

class FilterViewModel(
    useCases: FilterUseCases
) : MviViewModel<Action, State, SideEffect>(
    store = FilterStore(useCases)
)