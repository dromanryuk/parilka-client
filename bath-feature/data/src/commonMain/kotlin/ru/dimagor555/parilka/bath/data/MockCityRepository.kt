package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.repository.CityRepository

class MockCityRepository : CityRepository {
    override suspend fun getAll(): List<City> = listOf(City1, City2, City3)

    override suspend fun getCityById(id: Int): City? {
        val cities = listOf(City1, City2, City3)
        cities.forEach {
            if (it.id == id) return it
        }
        return null
    }

    override suspend fun findNearestByGeoCoordinate(geoCoordinate: GeoCoordinate): City = City1
}