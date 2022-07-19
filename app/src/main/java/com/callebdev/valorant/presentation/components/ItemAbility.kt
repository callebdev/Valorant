package com.callebdev.valorant.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.callebdev.valorant.domain.models.Ability
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemAbility(modifier: Modifier = Modifier, isCurrentlySelected: Boolean = false, ability: Ability, onAbilityClick: (ability: Ability) -> Unit) {

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

//    val abilityTransition = updateTransition(targetState = remember { mutableStateOf(isCurrentlySelected) }, label = "Ability Transition State")
//
//    val abilityIconSizeAnimationDurationInMillis = 1000
//    val abilityIconSizeInDp by abilityTransition.animateDp(label = "Ability Icon Text Size In Dp", transitionSpec = { tween(abilityIconSizeAnimationDurationInMillis) }) { isSelected ->
//        if (isSelected.value) 100.dp else 50.dp
//    }
//
//    val abilitySizeInSp by abilityTransition.animateInt(label = "Ability Icon Text Size In Dp", transitionSpec = { tween(abilityIconSizeAnimationDurationInMillis) }) { isSelected ->
//        if (isSelected.value) 12 else 50
//    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
        ) {
            onAbilityClick(ability)
        }
    ) {
        GlideImage(
            imageModel = ability.displayIcon,
            contentDescription = "Ability Item Icon",
            modifier = Modifier.size(50.dp).graphicsLayer {
                if (isCurrentlySelected) rotationZ = angle
            },
            circularReveal = CircularReveal(duration = 350),
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(text = ability.displayName, fontWeight = if (isCurrentlySelected) FontWeight.ExtraBold else FontWeight.Normal)
    }
}
