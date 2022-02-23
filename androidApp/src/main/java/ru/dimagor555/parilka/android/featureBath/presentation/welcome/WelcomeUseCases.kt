package ru.dimagor555.parilka.android.featureBath.presentation.welcome

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.FindNearestCityUseCase
import ru.dimagor555.parilka.bath.usecase.SetCitySettingsUseCase

class WelcomeUseCases(
    cityRepository: CityRepository,
    geoLocationRepository: GeoLocationRepository,
    settingsRepository: SettingsRepository
) {
    val findNearestCityUseCase = FindNearestCityUseCase(cityRepository, geoLocationRepository)
    val setCitySettingsUseCase = SetCitySettingsUseCase(settingsRepository)
}