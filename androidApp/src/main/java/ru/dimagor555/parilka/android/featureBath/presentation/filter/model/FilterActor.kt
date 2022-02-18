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
        val filters = useCases.getFiltersUseCase()
        val filterNames = filters.mapKeys { getFilterName(it.key) }
        sendMessage(Message.ShowFilters(filterNames))
    }

    private fun getFilterName(key: GetFiltersUseCase.FilterType): String {
        return when (key) {
            GetFiltersUseCase.FilterType.BATH_TYPE -> "Виды парной"
            GetFiltersUseCase.FilterType.BATH_SERVICE -> "Банные услуги"
            GetFiltersUseCase.FilterType.AQUA_SERVICE -> "Аквазона"
            GetFiltersUseCase.FilterType.ADDITIONAL_SERVICE -> "Доп. услуги"
            GetFiltersUseCase.FilterType.FOOD_SERVICE -> "Кухня"
        }
    }
}