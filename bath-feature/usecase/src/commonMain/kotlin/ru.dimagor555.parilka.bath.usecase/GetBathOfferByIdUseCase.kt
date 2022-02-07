package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.BathOfferRepository

class GetBathOfferByIdUseCase(
    private val bathOfferRepository: BathOfferRepository
) {
    suspend operator fun invoke(id: Int) = bathOfferRepository.getById(id)
}