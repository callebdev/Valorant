package com.callebdev.valorant.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val MyBlue = Color(0xFF009DE0)
val MyBlueLight = Color(0x14009DE0)
val DividerColor = Color(0x1F000000)

// Statefull
@Composable
fun Stepper(
    modifier: Modifier = Modifier,
    count: Int,
    onClickPlus: () -> Unit,
    onClickMinus: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var autoCollapseKey by remember { mutableStateOf(false) }

    if (expanded) {
        LaunchedEffect(autoCollapseKey) {
            delay(1500)
            expanded = false
        }
    }

    val transition = updateTransition(targetState = expanded, "expand")
    val width by transition.animateDp(label = "width") { isExpanded ->
        if (isExpanded) 100.dp else 36.dp
    }
    val color by transition.animateColor(label = "color") { isExpanded ->
        if (isExpanded) MyBlueLight else Color.Transparent
    }
    val borderColor by transition.animateColor(label = "border color") { isExpanded ->
        if (isExpanded) Color.Transparent else DividerColor
    }
    val iconAlpha by transition.animateFloat(label = "icons alpha") { isExpanded ->
        if (isExpanded) 1f else 0f
    }

    Stepper(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            expanded = !expanded
        },
        countValue = count.coerceAtLeast(0),
        width = width,
        color = color,
        borderColor = borderColor,
        iconAlpha = iconAlpha,
        onClickPlus = {
            autoCollapseKey = !autoCollapseKey
            onClickPlus()
        },
        onClickMinus = {
            autoCollapseKey = !autoCollapseKey
            onClickMinus()
        }
    )
}

// Stateless
@Composable
private fun Stepper(
    modifier: Modifier,
    countValue: Int,
    width: Dp,
    color: Color,
    borderColor: Color,
    iconAlpha: Float,
    onClickPlus: () -> Unit,
    onClickMinus: () -> Unit,
) {
    Surface(
        modifier = modifier
            .size(width, height = 36.dp),
        shape = RoundedCornerShape(size = 8.dp),
        color = color,
        border = BorderStroke(1.dp, borderColor)
    ) {
        Box {
            Text(
                "$countValue",
                Modifier.align(Alignment.Center),
                color = MyBlue,
                textAlign = TextAlign.Center
            )
            if (iconAlpha > 0) {
                StepperButton(
                    icon = Icons.Default.Clear,
                    onClick = onClickMinus,
                    Modifier
                        .alpha(iconAlpha)
                        .padding(
                            start = 6.dp,
                            top = 6.dp,
                            bottom = 6.dp
                        )
                )
                StepperButton(
                    icon = Icons.Rounded.Add,
                    onClick = onClickPlus,
                    Modifier
                        .alpha(iconAlpha)
                        .align(Alignment.CenterEnd)
                        .padding(
                            top = 6.dp,
                            bottom = 6.dp,
                            end = 6.dp
                        )
                )
            }
        }
    }
}

@Composable
fun StepperButton(icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(24.dp)
            .background(MaterialTheme.colors.background, shape = CircleShape)
            .clip(CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            imageVector = icon,
            contentDescription = "",
            tint = MyBlue
        )
    }
}

@Preview
@Composable
fun Preview() {
    MaterialTheme {
        Surface {
            Box(Modifier.fillMaxSize()) {
                var count by remember { mutableStateOf(0) }
                Stepper(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(32.dp),
                    count = count,
                    onClickMinus = { count-- },
                    onClickPlus = { count+100 }
                )
            }
        }
    }
}


@Composable
fun ColorChooser() {

    Surface() {



    }

}




