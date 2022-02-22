package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.FilterRepository

class SaveFiltersUseCase(
    private val filterRepository: FilterRepository,
) {
    operator fun invoke(filters: Set<String>) = filterRepository.setFilters(filters)
}