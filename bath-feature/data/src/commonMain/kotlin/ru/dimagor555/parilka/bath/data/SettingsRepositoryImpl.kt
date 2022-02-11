package ru.dimagor555.parilka.bath.data

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import ru.dimagor555.parilka.bath.repository.SettingsRepository

internal class SettingsRepositoryImpl: SettingsRepository {
    private val citySettings: Settings = Settings()

    override fun getValue(key: String): Int? =
        citySettings[key]

    override suspend fun setSavedCity(cityId: Int) {
        citySettings.putInt("cityId", cityId)
    }
}