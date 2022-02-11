package ru.dimagor555.parilka.android.featureBath.presentation.overview

import ru.dimagor555.mvicompose.android.MviViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.BathOverviewUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.*

class BathOverviewViewModel(
    useCases: BathOverviewUseCases
) : MviViewModel<Action, State, SideEffect>(
    store = OverviewBathStore(useCases)
)