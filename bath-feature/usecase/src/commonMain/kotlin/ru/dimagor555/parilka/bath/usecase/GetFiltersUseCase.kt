package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath
import ru.dimagor555.parilka.bath.usecase.GetFiltersUseCase.FilterType.*

private typealias Filters = MutableSet<String>

class GetFiltersUseCase(
    private val getBathOffers: GetBathOffersForUserCityUseCase
) {
    suspend operator fun invoke() = getAllFilters()

    private suspend fun getAllFilters(): Map<FilterType, Set<String>> {
        val filters = createMutableFilters()
        getBathOffers().forEach { bath ->
            filters[BATH_TYPE]!! += bath.content.bath.bathTypes
            bath.content.bath.servicesByTypes.forEach { (serviceType, services) ->
                filters[serviceType.toFilterType()]!! += services
            }
        }
        return filters
    }

    private fun createMutableFilters(): Map<FilterType, Filters> = buildMap {
        enumValues<FilterType>().forEach { filterType ->
            this[filterType] = mutableSetOf()
        }
    }

    private fun Bath.ServiceType.toFilterType() = when (this) {
        Bath.ServiceType.BATH -> BATH_SERVICE
        Bath.ServiceType.AQUA -> AQUA_SERVICE
        Bath.ServiceType.ADDITIONAL -> ADDITIONAL_SERVICE
        Bath.ServiceType.FOOD -> FOOD_SERVICE
    }

    enum class FilterType {
        BATH_TYPE, BATH_SERVICE, AQUA_SERVICE, ADDITIONAL_SERVICE, FOOD_SERVICE
    }
}