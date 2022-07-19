package com.callebdev.valorant.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.callebdev.valorant.R

@Preview(showSystemUi = true)
@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    onCloseError: (() -> Unit)? = null,
) {
    Box(modifier = Modifier.fillMaxSize().padding(24.dp)) {

        onCloseError?.let {
            Image(
                imageVector = Icons.Default.Close,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Close Error Screen",
                modifier = Modifier.align(Alignment.TopEnd).clickable { it() },
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.align(Alignment.Center)) {
            Image(painter = painterResource(R.drawable.valorant_error), contentDescription = "Valorant Error Icon", modifier = Modifier.size(200.dp))
            Spacer(modifier = Modifier.size(18.dp))
            Text(errorMessage ?: "Error!", style = MaterialTheme.typography.titleLarge, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}
