package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository

class FindNearestCityUseCase(
    private val cityRepository: CityRepository,
    private val geoLocationRepository: GeoLocationRepository
) {
    suspend operator fun invoke() =
        geoLocationRepository.getApproximateGeoCoordinate()
            ?.let { cityRepository.findNearestByGeoCoordinate(it) }
}