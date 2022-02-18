package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath
import ru.dimagor555.parilka.bath.usecase.GetFiltersUseCase.FilterType.*

class GetFiltersUseCase(
    private val getBathOffers: GetBathOffersForUserCityUseCase
) {
    suspend operator fun invoke() = getAllFilters()

    private suspend fun getAllFilters(): Map<FilterType, Set<String>> {
        val baths = getBathOffers()
        val filters = mutableMapOf<FilterType, Set<String>>()

        baths.forEach { bath ->
            filters[BATH_TYPE] = bath.content.bath.bathTypes
            bath.content.bath.servicesByTypes.forEach {
                when (it.key) {
                    Bath.ServiceType.BATH -> filters[BATH_SERVICE] = it.value
                    Bath.ServiceType.AQUA -> filters[AQUA_SERVICE] = it.value
                    Bath.ServiceType.ADDITIONAL -> filters[ADDITIONAL_SERVICE] = it.value
                    Bath.ServiceType.FOOD -> filters[FOOD_SERVICE] = it.value
                }
            }
        }

        return filters
    }

    enum class FilterType {
        BATH_TYPE, BATH_SERVICE, AQUA_SERVICE, ADDITIONAL_SERVICE, FOOD_SERVICE
    }
}