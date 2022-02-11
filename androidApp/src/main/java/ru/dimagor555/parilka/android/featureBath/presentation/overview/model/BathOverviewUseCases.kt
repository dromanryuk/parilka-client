package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetBathOffersByCityIdUseCase
import ru.dimagor555.parilka.bath.usecase.GetSettingsByKeyUseCase

class BathOverviewUseCases(
    bathOfferRepository: BathOfferRepository,
    settingsRepository: SettingsRepository
) {
    val getBaths = GetBathOffersByCityIdUseCase(bathOfferRepository)
    val getCityId = GetSettingsByKeyUseCase(settingsRepository)
}