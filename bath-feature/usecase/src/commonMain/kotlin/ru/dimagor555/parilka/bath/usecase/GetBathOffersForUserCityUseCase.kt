package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.bathoffer.BathOffer
import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository

class GetBathOffersForUserCityUseCase(
    private val bathOfferRepository: BathOfferRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): List<BathOffer> {
        val cityId = settingsRepository.get(SettingsRepository.USER_CITY_ID)
            ?: error("No user city id in settings")
        return bathOfferRepository.getByCityId(cityId)
    }
}