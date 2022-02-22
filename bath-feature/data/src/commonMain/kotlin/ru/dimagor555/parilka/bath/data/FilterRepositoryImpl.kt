package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.repository.FilterRepository

class FilterRepositoryImpl : FilterRepository{
    private val bathFilters = mutableSetOf<String>()

    override fun getFilters(): Set<String> = bathFilters

    override fun setFilters(filters: Set<String>) {
        bathFilters.clear()
        bathFilters.addAll(filters)
    }
}