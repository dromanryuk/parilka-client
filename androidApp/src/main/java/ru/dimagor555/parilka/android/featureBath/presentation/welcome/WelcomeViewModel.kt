package ru.dimagor555.parilka.android.featureBath.presentation.welcome

import ru.dimagor555.mvicompose.android.MviViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore.*

class WelcomeViewModel(
    useCases: WelcomeUseCases
) : MviViewModel<Action, State, SideEffect>(
    store = WelcomeStore(useCases)
)