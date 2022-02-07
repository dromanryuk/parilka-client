package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.CityRepository

class GetAllCitiesUseCase(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke() = cityRepository.getAll()
}

