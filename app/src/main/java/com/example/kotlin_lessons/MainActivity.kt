package com.example.kotlin_lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

// https://www.youtube.com/playlist?list=PLmjT2NFTgg1clSDgx1YYOuVyZuCXVjfuR

class MainActivity : AppCompatActivity() {
    private var number: Int = 6
    private var number2: Int = 4
    private var text1: String = "pepega has $number pepes" // $ перед переменной - впихивыает её в String
    private var text2: String = "but pupuga has ${getNumber()} pepes" // с ф-ей тоже самое работает если заключить её в {}
    private var telText: TextView? = null // '?' после типа говорит о том, что мы насильно разрешаем
                                          // переменной text1 иметь значение null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        telText = findViewById(R.id.text1)
        telText?.setText(text2)
    }

    // функция, которая возвращает тип данных Int
    // если после : ничего не указать, то ф-я не будет ничего возвращать (void)
    private fun getNumber(): Int{
        return number + number2
    }

}