package dev.kotlin_course.diceroller

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val rollButton: Button = findViewById(R.id.button)
    rollButton.setOnClickListener { loadRoll() }

    rollDice()
  }

  private fun loadRoll() {
    val delayMillis = 120
    val totalDurationMillis = 1000
    object : CountDownTimer(totalDurationMillis.toLong(), delayMillis.toLong()) {
      override fun onTick(millisUntilFinished: Long) {
        rollDice()
      }

      override fun onFinish() {}
    }.start()
  }

  private fun rollDice() {
    val diceImage: ImageView = findViewById(R.id.imageView)
    val dice = Dice(6)

    val diceRoll = dice.roll()
    val drawableResource = when (diceRoll) {
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }

    diceImage.setImageResource(drawableResource)
    diceImage.contentDescription = diceRoll.toString()
  }
}

class Dice(private val numSides: Int) {

  fun roll(): Int {
    return (1..numSides).random()
  }
}