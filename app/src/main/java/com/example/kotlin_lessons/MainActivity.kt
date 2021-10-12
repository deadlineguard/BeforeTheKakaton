package com.example.kotlin_lessons

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

// https://www.youtube.com/playlist?list=PLmjT2NFTgg1clSDgx1YYOuVyZuCXVjfuR

class MainActivity : AppCompatActivity() {
    private var number: Int = 42
    private var text1: TextView? = null // '?' после типа говорит о том, что мы насильно разрешаем
                                        // переменной text1 иметь значение null
    private var start: Boolean = false
    private var counter: Int = 0
    private var cLayout: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        text1?.setText(number.toString()) // знак '?' означает, что команда запустится только если
                                          // text1 != null - а у нас != null т.к. мы присвоили знач-е выше
        cLayout = findViewById(R.id.cLayout)
        Thread{
            start = true
            while (start){
                Thread.sleep(1000)

                // изменять эл-ты UI со второстепенного потока нельзя,
                // но если использовать runOnUiThread, то можно :)
                runOnUiThread{
                    if (counter == 5)
                        cLayout?.setBackgroundColor(Color.BLUE)
                    text1?.setText(counter.toString())
                    counter++
                }
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}