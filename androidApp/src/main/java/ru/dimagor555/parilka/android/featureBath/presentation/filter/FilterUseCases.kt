package ru.dimagor555.parilka.android.featureBath.presentation.filter

import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.FilterRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository
import ru.dimagor555.parilka.bath.usecase.GetBathFiltersUseCase
import ru.dimagor555.parilka.bath.usecase.GetSettingsByKeyUseCase
import ru.dimagor555.parilka.bath.usecase.SaveFiltersUseCase

class FilterUseCases(
    bathOfferRepository: BathOfferRepository,
    settingsRepository: SettingsRepository,
    filterRepository: FilterRepository
) {
    val getFiltersUseCase = GetBathFiltersUseCase(bathOfferRepository)
    val getSettingsByKeyUseCase = GetSettingsByKeyUseCase(settingsRepository)
    val saveFiltersUseCase = SaveFiltersUseCase(filterRepository)
}