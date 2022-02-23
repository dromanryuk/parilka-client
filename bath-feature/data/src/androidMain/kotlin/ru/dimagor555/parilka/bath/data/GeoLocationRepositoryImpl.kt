package ru.dimagor555.parilka.bath.data

import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository

internal class GeoLocationRepositoryImpl(
    private val context: Context
) : GeoLocationRepository {

    override suspend fun getApproximateGeoCoordinate(): GeoCoordinate? =
        context.locationManager.getLastLocationOrNull()?.let {
            GeoCoordinate(
                latitude = it.latitude,
                longitude = it.longitude
            )
        }

    private val Context.locationManager
        get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

    private fun LocationManager.getLastLocationOrNull(): Location? =
        getBestProviderOrNull()?.let {
            getLastKnownLocation(it)
        }

    private fun LocationManager.getBestProviderOrNull() = getBestProvider(Criteria(), true)
}