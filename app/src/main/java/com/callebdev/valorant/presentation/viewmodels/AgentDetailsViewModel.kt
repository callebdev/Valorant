package com.callebdev.valorant.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.callebdev.valorant.commons.Constants
import com.callebdev.valorant.commons.Resource
import com.callebdev.valorant.domain.usecases.get_agent.GetAgentUseCase
import com.callebdev.valorant.presentation.uistates.AgentDetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class AgentDetailsViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _agentsScreenState = mutableStateOf<AgentDetailsScreenState>(AgentDetailsScreenState.Loading)
    val agentsScreenState: State<AgentDetailsScreenState> = _agentsScreenState

    init {
        savedStateHandle.get<String>(Constants.PARAM_AGENT_UUID)?.let { getAgent(it) }
    }

    private fun getAgent(agentId: String) {
        getAgentUseCase(agentId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    if (result.data == null) {
                        _agentsScreenState.value = AgentDetailsScreenState.Error(result.message ?: "Unknown error")
                    } else {
                        _agentsScreenState.value = AgentDetailsScreenState.Success(result.data)
                    }
                }
                is Resource.Error -> _agentsScreenState.value = AgentDetailsScreenState.Error(result.message ?: "Unknown error")
                is Resource.Loading -> _agentsScreenState.value = AgentDetailsScreenState.Loading
            }
        }.launchIn(viewModelScope)
    }
}