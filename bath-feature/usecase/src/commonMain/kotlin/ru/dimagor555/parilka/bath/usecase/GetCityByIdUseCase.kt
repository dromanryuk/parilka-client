package ru.dimagor555.parilka.bath.usecase

import ru.dimagor555.parilka.bath.repository.CityRepository

class GetCityByIdUseCase(
     private val cityRepository: CityRepository
) {
    suspend operator fun invoke(cityId: Int) = cityRepository.getCityById(cityId)
}