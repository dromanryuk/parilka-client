package ru.dimagor555.parilka.android.featureBath.presentation.city.model

import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.Country

data class CityState(
    val id: Int,
    val name: String,
    val country: String
)

fun City.toCityState() = CityState(
    id = id,
    name = name,
    country = getCountryString(country)
)

fun getCountryString(country: Country) = when(country) {
    Country.RUSSIA -> "Россия"
    Country.UKRAINE -> "Украина"
}