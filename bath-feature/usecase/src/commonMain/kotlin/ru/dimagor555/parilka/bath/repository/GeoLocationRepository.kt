package ru.dimagor555.parilka.bath.repository

import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate

interface GeoLocationRepository {
    suspend fun getApproximateGeoCoordinate(): GeoCoordinate?
}