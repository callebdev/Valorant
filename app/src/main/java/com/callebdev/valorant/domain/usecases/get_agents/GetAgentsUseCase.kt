package com.callebdev.valorant.domain.usecases.get_agents

import com.callebdev.valorant.commons.Resource
import com.callebdev.valorant.data.remote.dto.toAgents
import com.callebdev.valorant.domain.models.Agent
import com.callebdev.valorant.domain.repositories.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(private val valorantRepository: ValorantRepository) {

    // use cases shall only have one public function
    operator fun invoke(): Flow<Resource<List<Agent>>> = flow {
        emit(Resource.Loading())
        try {
            val agents = valorantRepository.getAgents().toAgents()
            emit(Resource.Success(agents))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "No internet connection!"))
        }
    }
}
