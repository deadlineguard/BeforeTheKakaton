package com.example.beforethekakaton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

// https://www.youtube.com/watch?v=PKGCAs_4p4w&list=PLmjT2NFTgg1c-CC0l6GuvpH7_2JZBxqzf&index=4

public class MainActivity extends AppCompatActivity {
    private LinearLayout b1, b2, b3; // переменные лампочек
    private boolean start_stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.bulb1); // findViewByID() - найти эл-т по его Id
        b2 = findViewById(R.id.bulb2);
        b3 = findViewById(R.id.bulb3);
    }

    // что будет делать кнопка при клике
    public void onClickStart(View view) {
        /*
        Новый 'поток' (ветка) - он нужен чтобы внутри него исполнялась трудоёмкая опер-я
        т.к. если она будет вне потока, то она заморозит весь код (ничего не будет выполнятся
        кроме этой опер-ии).
        Поток сам закроется когда не будет действий
        */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start_stop) {

                }
            }
        }).start();
    }

    // метод вызовется при закрытии приложения (кнопка назад)
    @Override
    protected void onDestroy(){
        super.onDestroy();
        start_stop = false;
    }


    // что будет делать bulb1 при клике
    public void onClickBulb1(View view) {
        b2.setBackgroundColor(Color.BLACK);
    }
}