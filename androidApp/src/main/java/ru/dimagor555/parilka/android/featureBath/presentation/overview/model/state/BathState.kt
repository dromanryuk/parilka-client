package ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath
import ru.dimagor555.parilka.bath.domain.bathoffer.Bath.ServiceType

data class BathState(
    val bathTypes: Set<String>,
    val capacity: UByte,
    val servicesByTypes: Map<ServiceType, Set<String>>,
    val location: LocationState,
)

fun Bath.toBathState() = BathState(
    bathTypes = bathTypes,
    capacity = capacity,
    servicesByTypes = servicesByTypes,
    location = location.toLocationState()
)
