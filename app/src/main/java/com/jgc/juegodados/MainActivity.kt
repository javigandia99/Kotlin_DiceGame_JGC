package com.jgc.juegodados

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var j1TextView: TextView
    private lateinit var j2TextView: TextView
    private lateinit var buttonLeft: Button
    private lateinit var buttonRight: Button
    private lateinit var buttonExit: Button
    private lateinit var buttonLeftStand: Button
    private lateinit var buttonRightStand: Button
    private lateinit var j1ImageView: ImageView
    private lateinit var j2ImageView: ImageView
    private var number = 1
    private var j1_count = 0
    private var j2_count = 0
    var j1_stand = 0
    var j2_stand = 0
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        j1TextView = findViewById(R.id.j1_textView)
        j2TextView = findViewById(R.id.j2_textView)
        buttonLeft = findViewById(R.id.button_left)
        buttonRight = findViewById(R.id.button_right)
        buttonExit = findViewById(R.id.button_exit)

        buttonLeftStand = findViewById(R.id.button_left_pass)
        buttonRightStand = findViewById(R.id.button_right_pass)

        j1ImageView = findViewById((R.id.j1_imageView))
        j2ImageView = findViewById((R.id.j2_imageView))



        buttonLeft.setOnClickListener {
            randomNumber()
            posicion(1)
            j1_count += number
            j1TextView.text = (j1_count).toString()
            iswin()
        }

        buttonRight.setOnClickListener {
            randomNumber()
            posicion(0)
            j2_count += number
            j2TextView.text = (j2_count).toString()
            iswin()

        }

        buttonLeftStand.setOnClickListener() {
            j1_stand = j1_count
            j1TextView.text = j1_stand.toString()
            Log.e("1", j1_stand.toString())
            posicion(1)

        }

        buttonRightStand.setOnClickListener() {
            j2_stand = j2_count
            j2TextView.text = j2_stand.toString()
            Log.e("1", j2_stand.toString())
            posicion(0)
        }

        buttonExit.setOnClickListener() {
            reset()
        }
    }

    fun randomNumber() {
        number = (1..6).random()
        if (buttonLeft.isEnabled)
            j1_dados(number)
        if (buttonRight.isEnabled)
            j2_dados(number)

    }

    fun j1_dados(number: Int) {
        when (number) {
            1 -> {
                j1_imageView.setImageResource(R.drawable.dado1)
            }
            2 -> {
                j1_imageView.setImageResource(R.drawable.dado2)
            }
            3 -> {
                j1_imageView.setImageResource(R.drawable.dado3)
            }
            4 -> {
                j1_imageView.setImageResource(R.drawable.dado4)
            }
            5 -> {
                j1_imageView.setImageResource(R.drawable.dado5)
            }
            6 -> {
                j1_imageView.setImageResource(R.drawable.dado6)
            }
        }
    }

    fun j2_dados(number: Int) {
        when (number) {
            1 -> {
                j2_imageView.setImageResource(R.drawable.dado1)
            }
            2 -> {
                j2_imageView.setImageResource(R.drawable.dado2)
            }
            3 -> {
                j2_imageView.setImageResource(R.drawable.dado3)
            }
            4 -> {
                j2_imageView.setImageResource(R.drawable.dado4)
            }
            5 -> {
                j2_imageView.setImageResource(R.drawable.dado5)
            }
            6 -> {
                j2_imageView.setImageResource(R.drawable.dado6)
            }
        }
    }

    fun posicion(position: Int) {
        when (position) {
            0 -> {
                buttonLeft.isEnabled = true
                buttonRight.isEnabled = false
                buttonLeftStand.isEnabled = true
                buttonRightStand.isEnabled = false
                buttonLeft.setBackgroundColor(Color.BLUE)
                buttonLeftStand.setBackgroundColor(Color.BLUE)
                buttonRight.setBackgroundColor(Color.GRAY)
                buttonRightStand.setBackgroundColor(Color.GRAY)
            }
            1 -> {
                buttonLeft.isEnabled = false
                buttonRight.isEnabled = true
                buttonLeftStand.isEnabled = false
                buttonRightStand.isEnabled = true
                buttonLeft.setBackgroundColor(Color.GRAY)
                buttonLeftStand.setBackgroundColor(Color.GRAY)
                buttonRight.setBackgroundColor(Color.BLUE)
                buttonRightStand.setBackgroundColor(Color.BLUE)
            }
        }
    }

    fun iswin() {
        if (j1_count == 21) {
            var message = "J1 WINNER"
            Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
            fin()
        }
        if (j2_count == 21) {
            var message = "J2 WINNER"
            Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
            fin()
        }
        if (j1_count > 21) {
            var message = "J1 LOOSER"
            Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
            fin()
        }
        if (j2_count > 21) {
            var message = "J2 LOOSER"
            Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
            fin()
        }
    }

    fun reset() {
        var message = "MATCH RESET"
        Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
        j1_count = 0
        j2_count = 0
        buttonLeft.isEnabled = true
        buttonRight.isEnabled = false
        buttonLeftStand.isEnabled = true
        buttonRightStand.isEnabled = false
        j1TextView.text = j1_count.toString()
        j2TextView.text = j2_count.toString()
        buttonLeft.setBackgroundColor(Color.BLUE)
        buttonLeftStand.setBackgroundColor(Color.BLUE)
        buttonRight.setBackgroundColor(Color.GRAY)
        buttonRightStand.setBackgroundColor(Color.GRAY)
    }

    fun fin() {
        var message = "MATCH FINISHED"
        Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()
        buttonLeft.isEnabled = false
        buttonRight.isEnabled = false
        buttonLeftStand.isEnabled = false
        buttonRightStand.isEnabled = false

    }
}

