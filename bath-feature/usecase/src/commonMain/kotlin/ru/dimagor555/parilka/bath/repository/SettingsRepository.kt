package ru.dimagor555.parilka.bath.repository

interface SettingsRepository {
    fun getValue(key: String): Int?

    suspend fun setSavedCity(cityId: Int)
}