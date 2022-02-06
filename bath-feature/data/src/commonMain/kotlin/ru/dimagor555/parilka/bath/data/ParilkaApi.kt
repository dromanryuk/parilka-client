package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer
import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate

internal interface ParilkaApi {
    suspend fun getAllCities(): List<City>

    suspend fun findNearestCityByGeoCoordinate(geoCoordinate: GeoCoordinate): City

    suspend fun getBathOffersByCityId(cityId: Int): List<BathOffer>
}