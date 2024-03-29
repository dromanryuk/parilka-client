package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.repository.CityRepository

internal class NetworkCityRepository(
    private val api: ParilkaApi
) : CityRepository {

    override suspend fun getAll(): List<City> = api.getAllCities()

    override suspend fun getCityById(id: Int): City? {
        val cities = api.getAllCities()
        cities.forEach {
            if (it.id == id) return it
        }
        return null
    }

    override suspend fun findNearestByGeoCoordinate(geoCoordinate: GeoCoordinate): City =
        api.findNearestCityByGeoCoordinate(geoCoordinate)
}