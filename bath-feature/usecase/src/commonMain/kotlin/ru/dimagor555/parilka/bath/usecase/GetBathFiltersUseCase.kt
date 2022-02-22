package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath
import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.usecase.GetBathFiltersUseCase.FilterType.*

class GetBathFiltersUseCase(
    private val bathOfferRepository: BathOfferRepository,
) {
    suspend operator fun invoke(cityId: Int) = getAllFilters(cityId)

    private suspend fun getAllFilters(cityId: Int): Map<FilterType, Set<String>> {
        val baths = bathOfferRepository.getByCityId(cityId)
        val filters = mutableMapOf<FilterType, Set<String>>()
        FilterType.values().forEach {
            filters[it] = emptySet()
        }
        baths.forEach { bath ->
            filters[STEAM] = bath.content.bath.bathTypes.plus(filters[STEAM]!!)
            bath.content.bath.servicesByTypes.forEach {
                when (it.key) {
                    Bath.ServiceType.BATH -> filters[BATH] = it.value.plus(filters[BATH]!!)
                    Bath.ServiceType.AQUA -> filters[AQUA] = it.value.plus(filters[AQUA]!!)
                    Bath.ServiceType.ADDITIONAL -> filters[ADDITIONAL] = it.value.plus(filters[ADDITIONAL]!!)
                    Bath.ServiceType.FOOD -> filters[FOOD] = it.value.plus(filters[FOOD]!!)
                }
            }
        }
        return filters
    }

    enum class FilterType {
        STEAM, BATH, AQUA, ADDITIONAL, FOOD
    }
}