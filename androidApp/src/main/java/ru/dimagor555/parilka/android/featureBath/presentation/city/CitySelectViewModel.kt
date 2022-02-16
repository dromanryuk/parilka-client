package ru.dimagor555.parilka.android.featureBath.presentation.city

import ru.dimagor555.mvicompose.android.MviViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore.*

class CitySelectViewModel(
    useCases: CitySelectUseCases
) : MviViewModel<Action, State, SideEffect>(
    store = CitySelectStore(useCases)
)