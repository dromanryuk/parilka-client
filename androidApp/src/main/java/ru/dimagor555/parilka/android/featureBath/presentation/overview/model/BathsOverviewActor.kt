package ru.dimagor555.parilka.android.featureBath.presentation.overview.model

import ru.dimagor555.mvicompose.abstraction.Actor
import ru.dimagor555.parilka.android.featureBath.presentation.overview.BathOverviewUseCases
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.OverviewBathStore.*
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.BathOfferState
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.toBathOfferState

class BathsOverviewActor(
    private val useCases: BathOverviewUseCases,
) : Actor<State, Action, Message, SideEffect>() {
    override suspend fun onAction(action: Action) {
        when (action) {
            Action.InitScreen -> getBaths()
        }
    }

    private suspend fun getBaths() {
        val cityId = useCases.getCityId("cityId") ?: return
        val city = useCases.getCityById(cityId) ?: return
        sendMessage(Message.SetNearestCity(cityId, city.name))

        val markedFilters = useCases.getMarkedFilters()
        val bathsState = useCases.getBaths(cityId).map { it.toBathOfferState() }
        sendMessage(Message.SetMarkedFilters(markedFilters))
        checkBathByFilters(markedFilters, bathsState)
    }

    private suspend fun checkBathByFilters(
        markedFilters: Set<String>,
        bathsState: List<BathOfferState>,
    ) {
        val newBathsState = mutableListOf<BathOfferState>()
        if (markedFilters.isNotEmpty()) {
            bathsState.forEach { addBathToFilterList(markedFilters, it, newBathsState) }
            sendMessage(Message.ShowBathStates(newBathsState))
        } else {
            sendMessage(Message.ShowBathStates(bathsState))
        }
    }

    private fun addBathToFilterList(
        markedFilters: Set<String>,
        bathOfferState: BathOfferState,
        newBathsState: MutableList<BathOfferState>
    ) {
        val bathFilters = getAllBathFilters(bathOfferState)
        val contains = bathFilters.containsAll(markedFilters)
        if (contains)
            newBathsState.add(bathOfferState)
    }

    private fun getAllBathFilters(state: BathOfferState): MutableSet<String> {
        val bathFilters = mutableSetOf<String>()
        state.bath.servicesByTypes.forEach { (type, service) ->
            bathFilters.addAll(service)
        }
        return bathFilters
    }
}