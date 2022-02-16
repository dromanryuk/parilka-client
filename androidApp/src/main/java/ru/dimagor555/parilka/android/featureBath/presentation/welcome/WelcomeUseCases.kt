package ru.dimagor555.parilka.android.featureBath.presentation.welcome

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository
import ru.dimagor555.parilka.bath.usecase.FindNearestCityUseCase

class WelcomeUseCases(
    cityRepository: CityRepository,
    geoLocationRepository: GeoLocationRepository
) {
    val findNearestCityUseCase = FindNearestCityUseCase(cityRepository, geoLocationRepository)
}