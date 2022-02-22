package ru.dimagor555.parilka.bath.repository

interface FilterRepository {
    fun getFilters(): Set<String>

    fun setFilters(filters: Set<String>)
}