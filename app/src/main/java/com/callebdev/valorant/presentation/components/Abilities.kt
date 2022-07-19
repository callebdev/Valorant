package com.callebdev.valorant.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.callebdev.valorant.domain.models.Ability
import com.callebdev.valorant.presentation.theme.StartSideRoundedCornerShape

@Composable
fun Abilities(abilities: List<Ability>) {

    val currentSelectedAbility = remember { mutableStateOf<Ability?>(value = null) }

    Surface(modifier = Modifier.fillMaxWidth(), shape = StartSideRoundedCornerShape, color = MaterialTheme.colorScheme.secondary) {

        Column(modifier = Modifier.padding(start = 16.dp)) {

            Text(text = "Agent Abilities", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 16.dp))

            LazyRow {
                items(items = abilities, itemContent = { ability ->
                    ItemAbility(
                        ability = ability,
                        isCurrentlySelected = currentSelectedAbility.value == ability,
                        onAbilityClick = {
                            when (currentSelectedAbility.value) {
                                null -> currentSelectedAbility.value = ability
                                ability -> currentSelectedAbility.value = null
                                else -> currentSelectedAbility.apply {
                                    // todo: improve this logic
                                    value = null
                                    value = ability
                                }
                            }
                        }
                    )
                })
            }

            AnimatedVisibility(
                visible = currentSelectedAbility.value != null,
                enter = slideInHorizontally(),
                // exit = slideOutHorizontally(), // todo: fix currentSelectedAbility.value getting null, then enable it
            ) {
                Surface(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, bottom = 24.dp), shape = StartSideRoundedCornerShape) {
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        currentSelectedAbility.value?.displayName?.let {
                            Text(
                                text = it, fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.padding(end = 16.dp).padding(top = 16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        currentSelectedAbility.value?.description?.let { Text(text = it, modifier = Modifier.padding(end = 16.dp).padding(bottom = 16.dp)) }
                    }
                }
            }
        }
    }
}
