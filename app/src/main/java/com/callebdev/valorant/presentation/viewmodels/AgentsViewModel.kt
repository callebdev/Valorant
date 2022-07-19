package com.callebdev.valorant.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.callebdev.valorant.commons.Resource
import com.callebdev.valorant.domain.usecases.get_agents.GetAgentsUseCase
import com.callebdev.valorant.presentation.uistates.AgentsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val getAgentsUseCase: GetAgentsUseCase) : ViewModel() {

    private val _agentsScreenState = mutableStateOf<AgentsScreenState>(AgentsScreenState.Loading)
    val agentsScreenState: State<AgentsScreenState> = _agentsScreenState

    init {
        getAgents()
    }

    private fun getAgents() {
        getAgentsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> _agentsScreenState.value = AgentsScreenState.Success(result.data ?: emptyList())
                is Resource.Error -> _agentsScreenState.value = AgentsScreenState.Error(result.message ?: "Unknown error")
                is Resource.Loading -> _agentsScreenState.value = AgentsScreenState.Loading
            }
        }.launchIn(viewModelScope)
    }
}
