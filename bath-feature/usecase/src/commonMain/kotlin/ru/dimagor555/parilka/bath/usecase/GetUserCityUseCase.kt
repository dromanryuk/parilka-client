package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository

class GetUserCityUseCase(
    private val cityRepository: CityRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): City {
        val cityId = settingsRepository.get(SettingsRepository.USER_CITY_ID)
            ?: error("No user city id in settings")
        return cityRepository.getAll().find { it.id == cityId }
            ?: error("Invalid city id")
    }
}