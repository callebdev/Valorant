package com.callebdev.valorant.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.callebdev.valorant.domain.models.Agent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@ExperimentalPagerApi
@Composable
fun AgentsPagerSlider(agents: List<Agent>, onSeeCompleteInfoClicked: (Agent) -> Unit) {

    val pagerState = rememberPagerState(pageCount = agents.size)

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % (pagerState.pageCount), animationSpec = tween(600))
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
            ItemAgent(
                modifier = Modifier.fillMaxSize(),
                agents[page],
                /* todo: .graphicsLayer { val pageOffset = calculateCurrentOffsetF7orPage(page).absoluteValue } */
            ) { agent ->
                onSeeCompleteInfoClicked(agent)
            }
        }

        // Horizontal dot indicator not needed for now
        // HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 16.dp, horizontal = 72.dp))
    }
}
