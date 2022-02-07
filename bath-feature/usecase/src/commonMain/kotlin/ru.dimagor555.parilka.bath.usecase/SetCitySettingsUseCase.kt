package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.SettingsRepository

class SetCitySettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(cityId: Int) = settingsRepository.setSavedCity(cityId)
}