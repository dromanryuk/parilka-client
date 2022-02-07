package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.BathOfferRepository

class GetBathOffersByCityIdUseCase(
    private val bathOfferRepository: BathOfferRepository
) {
    suspend operator fun invoke(cityId: Int) = bathOfferRepository.getByCityId(cityId)
}