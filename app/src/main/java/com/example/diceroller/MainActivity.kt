package com.example.diceroller

import android.app.AppComponentFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    lateinit var  diceImage :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text="Let's Roll"
        rollButton.setOnClickListener(
           {
             rollDice()
              }

        )
        diceImage=findViewById(R.id.image_result)
    }

    private fun rollDice() {
        val result_Text : TextView = findViewById(R.id.result_text)
        val random_num = Random.nextInt(6) + 1
        result_Text.text=random_num.toString()
        val drawableImage = when(random_num){
            1 -> R.drawable.dice_1
            2-> R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableImage)


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello Android!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        Greeting("World")
    }
}