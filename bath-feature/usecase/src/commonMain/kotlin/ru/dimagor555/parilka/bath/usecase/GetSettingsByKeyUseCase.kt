package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.SettingsRepository

class GetSettingsByKeyUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(key: String) = settingsRepository.getValue(key)
}