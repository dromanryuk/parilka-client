package ru.dimagor555.parilka.bath.repository

interface SettingsRepository {
    suspend fun getValue(key: String): Any?

    suspend fun setSavedCity(cityId: Int)
}