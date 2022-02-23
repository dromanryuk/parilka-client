package ru.dimagor555.parilka.bath.data

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.repository.FilterRepository
import ru.dimagor555.parilka.bath.repository.SettingsRepository

val bathDataModule = module {
    single { createHttpClient() }
    single<ParilkaApi> { ParilkaApiImpl(get()) }
    single<CityRepository> { MockCityRepository() }
    single<BathOfferRepository> { MockBathOfferRepository() }
    single<SettingsRepository> { SettingsRepositoryImpl() }
    single<FilterRepository> { FilterRepositoryImpl() }
    createGeoLocationRepository(this)
}

private fun createHttpClient() = HttpClient {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
        serializer = KotlinxSerializer(json)
    }
}

internal expect fun createGeoLocationRepository(module: Module)