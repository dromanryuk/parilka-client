package ru.dimagor555.parilka.android.featureBath.presentation.overview

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetBathOffersForUserCityUseCase
import ru.dimagor555.parilka.bath.usecase.GetUserCityUseCase

class BathOverviewUseCases(
    bathOfferRepository: BathOfferRepository,
    settingsRepository: SettingsRepository,
    cityRepository: CityRepository
) {
    val getBathOffers = GetBathOffersForUserCityUseCase(bathOfferRepository, settingsRepository)
    val getUserCity = GetUserCityUseCase(cityRepository, settingsRepository)
}