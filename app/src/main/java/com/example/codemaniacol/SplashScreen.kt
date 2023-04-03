package com.example.codemaniacol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
// Этот клас проказывает загрузочный экран при запуске приложения
// 02.03.23
// Egor (Yzvan)
// Указание экрана на который ведет Splash с указаним длительности показа
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        Handler().postDelayed({
            startActivity(Intent(this,OnBoarding::class.java))
        },1000)
    }
}