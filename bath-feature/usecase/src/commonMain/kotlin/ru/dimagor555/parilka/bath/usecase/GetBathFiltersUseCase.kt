package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.domain.bathoffer.Bath
import ru.dimagor555.parilka.bath.repository.BathOfferRepository
import ru.dimagor555.parilka.bath.usecase.GetFiltersUseCase.FilterType.*

class GetFiltersUseCase(
    private val bathOfferRepository: BathOfferRepository
) {
    suspend operator fun invoke(cityId: Int) = getAllFilters(cityId)

    private suspend fun getAllFilters(cityId: Int): Map<FilterType, Set<String>> {
        val baths = bathOfferRepository.getByCityId(cityId)
        val filters = mutableMapOf<FilterType, Set<String>>()

        baths.forEach { bath ->
            filters[STEAM] = bath.content.bath.bathTypes
            bath.content.bath.servicesByTypes.forEach {
                when (it.key) {
                    Bath.ServiceType.BATH -> filters[BATH] = it.value
                    Bath.ServiceType.AQUA -> filters[AQUA] = it.value
                    Bath.ServiceType.ADDITIONAL -> filters[ADDITIONAL] = it.value
                    Bath.ServiceType.FOOD -> filters[FOOD] = it.value
                }
            }
        }

        return filters
    }

    enum class FilterType {
        STEAM, BATH, AQUA, ADDITIONAL, FOOD
    }
}