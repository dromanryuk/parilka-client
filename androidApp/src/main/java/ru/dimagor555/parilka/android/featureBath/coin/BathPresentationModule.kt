package ru.dimagor555.parilka.android.featureBath.coin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.city.CitySelectUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.city.CitySelectViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.overview.BathOverviewViewModel
import ru.dimagor555.parilka.android.featureBath.presentation.overview.BathOverviewUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.WelcomeUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.WelcomeViewModel

val bathPresentationModule = module {
    single { BathOverviewUseCases(get(), get(), get(), get()) }
    single { BathUseCases(get()) }
    single { CitySelectUseCases(get(), get()) }
    single { WelcomeUseCases(get(), get(), get()) }
    single { FilterUseCases(get(), get(), get()) }
    viewModel { BathOverviewViewModel(get()) }
    viewModel { BathViewModel(get()) }
    viewModel { CitySelectViewModel(get()) }
    viewModel { WelcomeViewModel(get()) }
    viewModel { FilterViewModel(get()) }
}