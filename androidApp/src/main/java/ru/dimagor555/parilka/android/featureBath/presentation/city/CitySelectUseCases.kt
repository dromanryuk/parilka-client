package ru.dimagor555.parilka.android.featureBath.presentation.city

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetAllCitiesUseCase
import ru.dimagor555.parilka.bath.usecase.SetCitySettingsUseCase

class CitySelectUseCases(
    cityRepository: CityRepository,
    settingsRepository: SettingsRepository
) {
    val getAllCitiesUseCase = GetAllCitiesUseCase(cityRepository)
    val setCitySettingsUseCase = SetCitySettingsUseCase(settingsRepository)
}