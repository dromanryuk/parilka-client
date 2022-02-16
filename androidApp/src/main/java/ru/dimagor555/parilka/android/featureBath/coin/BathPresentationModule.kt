package ru.dimagor555.parilka.android.featureBath.coin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.overview.BathOverviewViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.BathOverviewUseCases

val bathPresentationModule = module {
    single { BathOverviewUseCases(get(), get()) }
    single { BathUseCases(get()) }
    viewModel { BathOverviewViewModel(get()) }
    viewModel { BathViewModel(get()) }
}