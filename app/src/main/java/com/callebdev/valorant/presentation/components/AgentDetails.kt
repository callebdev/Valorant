package com.callebdev.valorant.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.callebdev.valorant.domain.models.Agent
import com.callebdev.valorant.presentation.theme.StartSideRoundedCornerShape
import com.callebdev.valorant.presentation.theme.color
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AgentDetails(agent: Agent, onNavigateBack: () -> Unit) {

    Column(modifier = Modifier.padding(start = 16.dp).fillMaxSize()) {
        Box(modifier = Modifier.height(300.dp).fillMaxWidth().padding(top = 24.dp), contentAlignment = Alignment.TopCenter) {

            GlideImage(
                imageModel = agent.background,
                contentDescription = "Agent Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 0.05f,
                circularReveal = CircularReveal(duration = 350),
            )

            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
                Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize().weight(1f)) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Agent Details Screen Back Button",
                        modifier = Modifier.padding(vertical = 8.dp).clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                        ) {
                            onNavigateBack()
                        }
                    )

                    Column(modifier = Modifier.align(alignment = Alignment.CenterHorizontally), verticalArrangement = Arrangement.Top) {

                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                                Surface(
                                    modifier = Modifier.size(100.dp),
                                    shape = RoundedCornerShape(percent = 45),
                                    border = BorderStroke(2.dp, color = agent.backgroundGradientColors[0].color),
                                ) {
                                    GlideImage(imageModel = agent.displayIcon, contentDescription = "Agent display icon", circularReveal = CircularReveal(duration = 350))
                                }
                                Text(
                                    text = agent.displayName,
                                    style = MaterialTheme.typography.headlineMedium,
                                    maxLines = 2,
                                    fontWeight = FontWeight.SemiBold,
                                )

                                OutlinedButton(onClick = {
                                }) {
                                    Text(text = "${agent.displayName}'s Voice")
                                }
                            }
                        }
                    }
                }

                GlideImage(
                    imageModel = agent.bustPortrait,
                    contentDescription = "Agent bust portrait",
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentScale = ContentScale.Crop,
                    circularReveal = CircularReveal(duration = 350),
                )
            }
        }

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Abilities(agent.abilities)
            Spacer(modifier = Modifier.size(8.dp))
            Surface(modifier = Modifier.fillMaxWidth(), shape = StartSideRoundedCornerShape, color = MaterialTheme.colorScheme.secondary) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Agent Biography", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = agent.description)
                }
            }
        }
    }
}
