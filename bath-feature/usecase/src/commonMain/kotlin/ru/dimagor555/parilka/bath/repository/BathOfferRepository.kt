package ru.dimagor555.parilka.bath.repository

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer

interface BathOfferRepository {
    suspend fun getByCityId(cityId: Int): List<BathOffer>

    suspend fun getById(id: Int): BathOffer?
}