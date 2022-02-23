package ru.dimagor555.parilka.android.featureBath.presentation.overview

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.FilterRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetBathOffersByCityIdUseCase
import ru.dimagor555.parilka.bath.usecase.GetCityByIdUseCase
import ru.dimagor555.parilka.bath.usecase.GetMarkedFilters
import ru.dimagor555.parilka.bath.usecase.GetSettingsByKeyUseCase

class BathOverviewUseCases(
    bathOfferRepository: BathOfferRepository,
    settingsRepository: SettingsRepository,
    cityRepository: CityRepository,
    filterRepository: FilterRepository
) {
    val getBaths = GetBathOffersByCityIdUseCase(bathOfferRepository)
    val getCityId = GetSettingsByKeyUseCase(settingsRepository)
    val getCityById = GetCityByIdUseCase(cityRepository)
    val getMarkedFilters = GetMarkedFilters(filterRepository)
}