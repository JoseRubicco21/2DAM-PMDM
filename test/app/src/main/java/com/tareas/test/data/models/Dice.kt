package com.tareas.test.data.models

import androidx.compose.ui.graphics.painter.Painter

data class Dice (
    val imageRes : Int,
    val diceType : DiceType,
    ){

    fun roll(): Int{
        return  (1..diceType.sides).random()
    }
}