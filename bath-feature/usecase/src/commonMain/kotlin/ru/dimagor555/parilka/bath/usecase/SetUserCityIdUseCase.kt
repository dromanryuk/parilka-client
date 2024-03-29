package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.SettingsRepository

class SetUserCityIdUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(cityId: Int) {
        settingsRepository.set(SettingsRepository.USER_CITY_ID, cityId)
    }
}