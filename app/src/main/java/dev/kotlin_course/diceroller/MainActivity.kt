package dev.kotlin_course.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val resultTextView: TextView = findViewById(R.id.textView)

        rollButton.setOnClickListener { resultTextView.text = rollDice() }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

fun rollDice(): String {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    return diceRoll.toString()
}