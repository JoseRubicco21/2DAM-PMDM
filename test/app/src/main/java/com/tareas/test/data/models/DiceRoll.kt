package com.tareas.test.data.models

data class DiceRoll (
    val dice : Dice,
    var result : Int = dice.roll()
)