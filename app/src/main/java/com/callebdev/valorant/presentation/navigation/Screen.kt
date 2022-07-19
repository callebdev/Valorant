package com.callebdev.valorant.presentation.navigation

sealed class Screen(val route: String) {

    companion object {
        private const val AGENTS_LIST_SCREEN = "agents_list_screen"
        private const val AGENT_DETAILS_SCREEN = "agent_details_screen"
    }

    object AgentsScreen : Screen(AGENTS_LIST_SCREEN)
    object AgentDetails : Screen(AGENT_DETAILS_SCREEN)
}
