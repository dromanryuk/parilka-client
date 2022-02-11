package ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer

data class BathOfferState(
    val id: Int,
    val name: String,
    val bath: BathState,
    val price: UInt,
    val phoneNumber: String,
    val imageUrls: Set<String>
)

fun BathOffer.toBathOfferState() = BathOfferState(
    id = id,
    name = content.name,
    bath = content.bath.toBathState(),
    price = content.bathRentTerms.minPrice,
    phoneNumber = content.phoneNumber.format.countryCode + content.phoneNumber.number,
    imageUrls = content.imageUrls
)


