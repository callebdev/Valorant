package com.callebdev.valorant.domain.usecases.get_agent

import com.callebdev.valorant.commons.Resource
import com.callebdev.valorant.data.remote.dto.toAgent
import com.callebdev.valorant.domain.models.Agent
import com.callebdev.valorant.domain.repositories.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentUseCase @Inject constructor(private val valorantRepository: ValorantRepository) {

    operator fun invoke(agentId: String): Flow<Resource<Agent>> = flow {
        emit(Resource.Loading())
        try {
            val agent = valorantRepository.getAgentById(agentId).toAgent()
            emit(Resource.Success(agent))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "No internet connection!"))
        }
    }
}
