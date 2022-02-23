package ru.dimagor555.parilka.bath.data

import org.koin.core.module.Module
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.repository.GeoLocationRepository

class MockGeoLocationRepository : GeoLocationRepository {
    override suspend fun getApproximateGeoCoordinate(): GeoCoordinate =
        GeoCoordinate(25.3, 32.2)
}

internal actual fun createGeoLocationRepository(module: Module) {
    module.single<GeoLocationRepository> {
        MockGeoLocationRepository()
    }
}