package ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.BathRentTerms

data class BathRentTermsState(
    val priceNames: Set<String> = emptySet(),
    val promotions: Set<String> = emptySet(),
    val minPrice: UInt = 0u,
    val minRentHours: UByte = 0u
)

fun BathRentTerms.toBathRentTermsState() = BathRentTermsState(
    priceNames = priceNames,
    promotions = promotions,
    minPrice = minPrice,
    minRentHours = minRentHours
)