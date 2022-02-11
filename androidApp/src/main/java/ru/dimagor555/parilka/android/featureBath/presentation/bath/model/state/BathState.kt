package ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath

data class BathState(
    val bathTypes: Set<String> = emptySet(),
    val capacity: UByte = 0u,
    val servicesByTypes: Map<Bath.ServiceType, Set<String>> = emptyMap(),
    val location: LocationState = LocationState()
)

fun Bath.toBathState() = BathState(
    bathTypes = bathTypes,
    capacity = capacity,
    servicesByTypes = servicesByTypes,
    location = location.toLocationState()
)