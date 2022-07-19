package com.callebdev.valorant.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.callebdev.valorant.domain.models.Agent
import com.callebdev.valorant.presentation.theme.BottomRoundedCornerShape
import com.callebdev.valorant.presentation.theme.TopRoundedCornerShape
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemAgent(
    modifier: Modifier = Modifier,
    agent: Agent,
    onSeeCompleteInfoClicked: (Agent) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize().padding(18.dp)) {

        // Agent Image Container
        Box(modifier = Modifier.fillMaxSize().weight(1f)) {

            Column(modifier = modifier.fillMaxSize()) {
                Spacer(modifier.fillMaxSize().weight(1f))
                Surface(modifier = modifier.fillMaxSize().weight(1f), color = MaterialTheme.colorScheme.secondary, shape = TopRoundedCornerShape) {}
            }

            GlideImage(
                imageModel = agent.fullPortrait,
                contentDescription = "Agent full portrait",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Inside,
                circularReveal = CircularReveal(duration = 350),
            )
        }

        // Agent Description
        Surface(modifier = Modifier.fillMaxSize().weight(1f), color = MaterialTheme.colorScheme.secondary, shape = BottomRoundedCornerShape) {
            Column(modifier = Modifier.padding(horizontal = 18.dp)) {
                Column(modifier = Modifier.fillMaxSize().weight(1f)) {
                    Text(text = agent.displayName, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.size(18.dp))
                    Text(text = agent.description, maxLines = 4, overflow = TextOverflow.Ellipsis)
                    Spacer(modifier = Modifier.size(18.dp))
                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp).clickable { onSeeCompleteInfoClicked(agent) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("See complete info", color = Color.White)
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "See complete info icon", tint = Color.White)
                }
            }
        }
    }
}
