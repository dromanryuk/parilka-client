package ru.dimagor555.parilka.bath.repository

import kotlin.reflect.KClass

interface SettingsRepository {
    suspend fun <T : Any> get(property: Property<T>): T?

    suspend fun <T : Any> set(property: Property<T>, value: T?)

    data class Property<T : Any>(
        val key: String,
        val kClass: KClass<T>
    )

    companion object Properties {
        val USER_CITY_ID = Property(key = "userCityId", kClass = Int::class)
    }
}