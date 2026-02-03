import com.tareas.test.data.models.DiceRoll


data class DiceRollResult(
    val diceRolls : List<DiceRoll>
) {
    val totalResult: Int
        get() = diceRolls.sumOf { roll -> roll.dice.roll() }
}