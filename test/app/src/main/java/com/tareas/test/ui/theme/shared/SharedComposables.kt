package com.tareas.test.ui.theme.shared

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tareas.test.R
import com.tareas.test.data.models.Dice
import com.tareas.test.data.models.DiceType

@Composable
fun DiceCard(modifier: Modifier, dice: Dice){
    Surface(modifier = modifier) {

    }
}

// Example dice:
val exampleDice = Dice(diceType = DiceType.D4, imageRes = R.drawable.d20)
@Composable
@Preview
fun DiceCardPreview(modifier : Modifier = Modifier, dice : Dice = exampleDice){
    ElevatedCard(modifier = modifier) {
        Column(modifier = modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp))
        {
            Image(
                painter = painterResource(dice.imageRes),
                contentDescription = "t"
            )
            Row(modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly) {
                IconButton(modifier = modifier, onClick = {},
                    ) {
                    Icon(modifier = modifier,
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "c"
                        )
                }
                Text(text = "123",
                    modifier = modifier,
                    textAlign = TextAlign.Start
                    )
                IconButton(
                    modifier =modifier, onClick = {}
                ) {
                    Icon(modifier = modifier,
                        imageVector = Icons.Filled.Add,
                        contentDescription = "c"
                    ) }

            }
        }
    }
}