package ru.dimagor555.parilka.bath.repository

import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate

interface CityRepository {
    suspend fun getAll(): List<City>

    suspend fun findNearestByGeoCoordinate(geoCoordinate: GeoCoordinate): City
}