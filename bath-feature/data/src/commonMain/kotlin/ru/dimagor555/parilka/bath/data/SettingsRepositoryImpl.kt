package ru.dimagor555.parilka.bath.data

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import ru.dimagor555.parilka.bath.repository.SettingsRepository

internal class SettingsRepositoryImpl : SettingsRepository {
    private val settings: Settings = Settings()

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T : Any> get(property: SettingsRepository.Property<T>): T? = property.run {
        when (kClass) {
            Int::class -> settings.getIntOrNull(key) as T?
            else -> error("Invalid type")
        }
    }

    override suspend fun <T : Any> set(property: SettingsRepository.Property<T>, value: T?) = property.run {
        when (kClass) {
            Int::class -> settings[key] = value as Int?
            else -> error("Invalid type")
        }
    }
}