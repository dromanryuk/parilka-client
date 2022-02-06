package ru.dimagor555.parilka.bath.data

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer
import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate

internal class ParilkaApiImpl(
    private val client: HttpClient
) : ParilkaApi {

    override suspend fun getAllCities(): List<City> =
        client.get(API_CITY_URL)

    override suspend fun findNearestCityByGeoCoordinate(geoCoordinate: GeoCoordinate): City =
        client.post(API_FIND_NEAREST_URL) {
            contentType(ContentType.Application.Json)
            body = geoCoordinate
        }

    override suspend fun getBathOffersByCityId(cityId: Int): List<BathOffer> =
        client.get("$API_BATH_OFFER_URL/$cityId")

    companion object {
        private const val API_BASE_URL = "https://pinesapps.com/api/v1"
        private const val API_CITY_URL = "$API_BASE_URL/city"
        private const val API_FIND_NEAREST_URL = "$API_CITY_URL/find-nearest"
        private const val API_BATH_OFFER_URL = "$API_BASE_URL/bath-offer"
    }
}