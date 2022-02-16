package ru.dimagor555.parilka.android.featureBath.presentation.city

import ru.dimagor555.parilka.bath.repository.CityRepository
import ru.dimagor555.parilka.bath.usecase.GetAllCitiesUseCase

class CitySelectUseCases(
    cityRepository: CityRepository
) {
    val getAllCitiesUseCase = GetAllCitiesUseCase(cityRepository)
}