package ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.Location

data class LocationState(
    val address: String,
    val subwayStation: String?,
    val district: String?,
)

fun Location.toLocationState() =  LocationState(
    address = address,
    subwayStation = subwayStation,
    district = district
)
