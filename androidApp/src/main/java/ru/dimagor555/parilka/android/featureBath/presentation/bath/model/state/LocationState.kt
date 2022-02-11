package ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.Location

data class LocationState(
    val address: String = "",
    val subwayStation: String? = null,
    val district: String? = null,
    val googleMapUrl: String = ""
)

fun Location.toLocationState() =  LocationState(
    address = address,
    subwayStation = subwayStation,
    district = district,
    googleMapUrl = googleMapUrl
)
