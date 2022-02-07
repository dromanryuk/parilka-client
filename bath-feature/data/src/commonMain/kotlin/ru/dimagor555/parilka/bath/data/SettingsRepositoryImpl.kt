package ru.dimagor555.parilka.bath.data

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import ru.dimagor555.parilka.bath.repository.SettingsRepository

internal class SettingsRepositoryImpl: SettingsRepository {
    private val citySettings: Settings = Settings()

    override suspend fun getValue(key: String): Any? =
        citySettings[key]

    override suspend fun setSavedCity(cityId: Int) {
        citySettings.putInt("cityId", cityId)
    }
}