package ru.dimagor555.parilka.android.featureBath.presentation.filter

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetBathOffersForUserCityUseCase
import ru.dimagor555.parilka.bath.usecase.GetFiltersUseCase

class FilterUseCases(
    bathOfferRepository: BathOfferRepository,
    settingsRepository: SettingsRepository
) {
    val getFiltersUseCase = GetFiltersUseCase(
        GetBathOffersForUserCityUseCase(
            bathOfferRepository,
            settingsRepository
        )
    )
}