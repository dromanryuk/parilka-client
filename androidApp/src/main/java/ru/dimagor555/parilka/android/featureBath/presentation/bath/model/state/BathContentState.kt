package ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOfferContent

data class BathContentState(
    val name: String = "",
    val bath: BathState = BathState(),
    val bathRentTerms: BathRentTermsState = BathRentTermsState(),
    val description: String? = null,
    val phoneNumber: String = "",
    val imageUrls: Set<String> = emptySet()
)

fun BathOfferContent.toBathContentState() = BathContentState(
    name = name,
    bath = bath.toBathState(),
    bathRentTerms = bathRentTerms.toBathRentTermsState(),
    description = description,
    phoneNumber = phoneNumber.format.countryCode + phoneNumber.number,
    imageUrls = imageUrls
)
