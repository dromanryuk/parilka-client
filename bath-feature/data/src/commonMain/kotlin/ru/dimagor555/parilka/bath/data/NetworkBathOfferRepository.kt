package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer
import ru.dimagor555.parilka.bath.repository.BathOfferRepository

internal class NetworkBathOfferRepository(
    private val api: ParilkaApi
) : BathOfferRepository {
    private var bathOffersByIds: Map<Int, BathOffer>? = null

    override suspend fun getByCityId(cityId: Int): List<BathOffer> {
        val bathOffers = api.getBathOffersByCityId(cityId)
        bathOffersByIds = bathOffers.associateBy { it.id }
        return bathOffers
    }

    override suspend fun getById(id: Int): BathOffer? =
        bathOffersByIds?.get(id)
}