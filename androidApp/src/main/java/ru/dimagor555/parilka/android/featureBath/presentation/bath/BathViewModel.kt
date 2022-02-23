package ru.dimagor555.parilka.android.featureBath.presentation.bath

import ru.dimagor555.mvicompose.android.MviViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore.*

class BathViewModel(
    useCases: BathUseCases
) : MviViewModel<Action, State, SideEffect>(
    store = BathStore(useCases)
)