package ru.dimagor555.parilka.bath.data

import org.koin.core.module.Module
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository

internal class GeoLocationRepositoryImpl : GeoLocationRepository {

    override suspend fun getApproximateGeoCoordinate(): GeoCoordinate? =
        TODO("Ios location repository not implemented yet")
}

internal actual fun createGeoLocationRepository(module: Module) {
    module.single<GeoLocationRepository> {
        GeoLocationRepositoryImpl()
    }
}