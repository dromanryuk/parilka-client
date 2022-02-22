package ru.dimagor555.parilka.android.featureBath.presentation.filter.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.filter.model.FilterStore.Action.InitScreen
import ru.dimagor555.parilka.bath.usecase.GetBathFiltersUseCase

class FilterActor(
    private val useCases: FilterUseCases,
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            is InitScreen -> getFilters()
            is Action.MarkFilter -> markFilter(action.filter, action.isMarked)
            is Action.SaveMarkedFilters -> saveMarkedFilters(action.markedFilters)
        }
    }

    private suspend fun getFilters() {
        val cityId = useCases.getSettingsByKeyUseCase("cityId") ?: return
        val filters = useCases.getFiltersUseCase(cityId)
        val filterNames = filters.mapKeys { getFilterName(it.key) }
        sendMessage(Message.ShowFilters(filterNames))
    }

    private fun getFilterName(key: GetBathFiltersUseCase.FilterType): String {
        return when (key) {
            GetBathFiltersUseCase.FilterType.STEAM -> "Виды парной"
            GetBathFiltersUseCase.FilterType.BATH -> "Банные услуги"
            GetBathFiltersUseCase.FilterType.AQUA -> "Аквазона"
            GetBathFiltersUseCase.FilterType.ADDITIONAL -> "Доп. Услуги"
            GetBathFiltersUseCase.FilterType.FOOD -> "Кухня"
        }
    }

    private suspend fun markFilter(filter: String, marked: Boolean) {
        sendMessage(Message.MarkFilter(filter, marked))
    }

    private fun saveMarkedFilters(markedFilters: Set<String>) {
        useCases.saveFiltersUseCase(markedFilters)
    }
}