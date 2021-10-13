package com.example.kotlin_lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

// https://www.youtube.com/playlist?list=PLmjT2NFTgg1clSDgx1YYOuVyZuCXVjfuR

class MainActivity : AppCompatActivity() {
    private var text: String = "В <магазине> осталось 123 яблока а может и <больше кто знает>"
    private var telText: TextView? = null
    private var telText2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        telText = findViewById(R.id.text1)
        telText2 = findViewById(R.id.text3)

        // "примитивный парсинг"
        var subText: String = text.substringAfter('<') // находим первое совпадение с '<' и всё что дальше него - пихаем в subText
        var subText2: String = subText.substringBefore('>') // неходим первое совпадение с '>' и всё что перед ним - пихаем в subText2
        telText?.setText(subText2)

        // а вот так можно вторую фразу захватить
        var subText3: String = text.substringAfter('>')
        var subText4: String = subText3.substringAfter('<')
        var subText5: String = subText4.substringBefore('>')
        telText2?.setText(subText5)
    }

}