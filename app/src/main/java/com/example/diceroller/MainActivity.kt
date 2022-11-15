package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var image_dice: ImageView
    //with this line I promise I'm using a non null value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get the reference for the button
        val button_roll: Button = findViewById(R.id.button_roll)
        image_dice = findViewById(R.id.image_dice)
        //show a new text on the button
        button_roll.text = "Vamos rolar o dado!"
        //run some code after a click
        button_roll.setOnClickListener {
            //display a message using Toast
            rollDice()
            //Toast.makeText(this, "Botão clicado!",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        //val image_dice: ImageView = findViewById(R.id.image_dice)
        val text_value: TextView = findViewById(R.id.text_value)
        text_value.text = "Let's roll!"
        image_dice.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {
        //val image_dice: ImageView = findViewById(R.id.image_dice)
        val text_value: TextView = findViewById(R.id.text_value)
        val randomNumber = Random().nextInt(6) + 1
        text_value.text = randomNumber.toString()
        /*if (randomNumber == 1)
            image_dice.setImageResource(R.drawable.dice_1)
        else if (randomNumber == 2)
            image_dice.setImageResource(R.drawable.dice_2)
        else if (randomNumber == 3)
            image_dice.setImageResource(R.drawable.dice_3)
        else if (randomNumber == 4)
            image_dice.setImageResource(R.drawable.dice_4)
        else if (randomNumber == 5)
            image_dice.setImageResource(R.drawable.dice_5)
        else if (randomNumber == 6)
            image_dice.setImageResource(R.drawable.dice_6)
            */
        val imageResourceSelected = when (randomNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        image_dice.setImageResource(imageResourceSelected)
    }
}