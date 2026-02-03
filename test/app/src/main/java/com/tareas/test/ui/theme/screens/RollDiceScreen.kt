package com.tareas.test.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RollDiceScreen(name: String, modifier: Modifier = Modifier) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .safeDrawingPadding()) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}