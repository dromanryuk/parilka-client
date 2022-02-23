package ru.dimagor555.parilka.android.featureBath.presentation.city

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetAllCitiesUseCase
import ru.dimagor555.parilka.bath.usecase.SetUserCityIdUseCase

class CitySelectUseCases(
    cityRepository: CityRepository,
    settingsRepository: SettingsRepository
) {
    val getAllCities = GetAllCitiesUseCase(cityRepository)
    val setUserCityId = SetUserCityIdUseCase(settingsRepository)
}