package app.aoyagi.makkan.calculator

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var firstNumber = 0
    var secondNumber = 0
    var totalNumber = 0
    var operator = "empty"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        plusButton.isEnabled = false
        minusButton.isEnabled = false
        multiplyButton.isEnabled = false
        equalButton.isEnabled = false

        numberText.text = firstNumber.toString()

        numberButton0.setOnClickListener {
            calculation(0)
        }
        numberButton1.setOnClickListener {
            calculation(1)
        }
        numberButton2.setOnClickListener {
            calculation(2)
        }
        numberButton3.setOnClickListener {
            calculation(3)
        }
        numberButton4.setOnClickListener {
            calculation(4)
        }
        numberButton5.setOnClickListener {
            calculation(5)
        }
        numberButton6.setOnClickListener {
            calculation(6)
        }
        numberButton7.setOnClickListener {
            calculation(7)
        }
        numberButton8.setOnClickListener {
            calculation(8)
        }
        numberButton9.setOnClickListener {
            calculation(9)
        }

        plusButton.setOnClickListener {
            button_set(plusButton, minusButton, multiplyButton, "plus")
        }
        minusButton.setOnClickListener {
            button_set(minusButton, plusButton, multiplyButton, "minus")
        }
        multiplyButton.setOnClickListener {
            button_set(multiplyButton, plusButton, minusButton, "multiply")
        }

        equalButton.setOnClickListener {

            when (operator) {

                "plus" -> {
                    totalNumber = firstNumber + secondNumber
                }

                "minus" -> {
                    totalNumber = firstNumber - secondNumber
                }
                "multiply" -> {
                    totalNumber = firstNumber * secondNumber
                }
            }

            clear()
            numberText.text = totalNumber.toString()
        }

        clearButton.setOnClickListener {

            clear()
            totalNumber = 0
            numberText.text = totalNumber.toString()

        }
    }


    fun calculation(num: Int) {

        if (operator == "empty") {
            firstNumber = firstNumber * 10 + num
            numberText.text = firstNumber.toString()
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))

            plusButton.isEnabled = true
            minusButton.isEnabled = true
            multiplyButton.isEnabled = true
            equalButton.isEnabled = true

        } else {
            secondNumber = secondNumber * 10 + num
            numberText.text = secondNumber.toString()

            equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 240))

        }

    }

    fun button_set(id1: Button, id2: Button, id3: Button, operate: String) {
        id1.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
        id2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        id3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        operator = operate

        numberText.text = secondNumber.toString()

    }

    fun clear() {
        plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        firstNumber = 0
        secondNumber = 0
        operator = "empty"
    }
}
