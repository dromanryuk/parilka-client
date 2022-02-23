package ru.dimagor555.parilka.android.featureBath.presentation.bath

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.usecase.GetBathOfferByIdUseCase

class BathUseCases(
    bathOfferRepository: BathOfferRepository
) {
    val observeBath = GetBathOfferByIdUseCase(bathOfferRepository)
}