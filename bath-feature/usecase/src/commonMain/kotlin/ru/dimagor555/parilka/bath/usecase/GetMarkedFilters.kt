package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.FilterRepository

class GetMarkedFilters(
    private val filterRepository: FilterRepository
) {
    operator fun invoke() = filterRepository.getFilters()
}