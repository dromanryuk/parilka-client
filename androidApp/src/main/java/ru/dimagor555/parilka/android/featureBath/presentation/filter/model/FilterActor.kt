package ru.dimagor555.parilka.android.featureBath.presentation.filter.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.Action.InitScreen
import ru.dimagor555.parilka.bath.usecase.GetFiltersUseCase

class FilterActor(
    private val useCases: FilterUseCases,
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            is InitScreen -> getFilters()
        }
    }

    private suspend fun getFilters() {
        val cityId = useCases.getSettingsByKeyUseCase("cityId") ?: return
        val filters = useCases.getFiltersUseCase(cityId)
        val filterNames = filters.mapKeys { getFilterName(it.key) }
        sendMessage(Message.ShowFilters(filterNames))
    }

    private fun getFilterName(key: GetFiltersUseCase.FilterType): String {
        return when (key) {
            GetFiltersUseCase.FilterType.STEAM -> "Виды парной"
            GetFiltersUseCase.FilterType.BATH -> "Банные услуги"
            GetFiltersUseCase.FilterType.AQUA -> "Аквазона"
            GetFiltersUseCase.FilterType.ADDITIONAL -> "Доп. Услуги"
            GetFiltersUseCase.FilterType.FOOD -> "Кухня"
        }
    }
}