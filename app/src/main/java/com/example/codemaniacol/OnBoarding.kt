package com.example.codemaniacol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.codemaniacol.databinding.ActivityOnBoardingBinding

class OnBoarding : AppCompatActivity() {
    lateinit var OnBoardingActivity : ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OnBoardingActivity = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(OnBoardingActivity.root)
        val button2 = findViewById<Button>(R.id.button2)

        setContentView(R.layout.activity_on_boarding)
        val list = listOf(OnBoard("Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно",R.drawable.blog_post_bro_1),
            OnBoard("Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно",R.drawable.novelist_writing_bro_1),
            OnBoard("Обучение онлайн из любой точки мира\n" +
                    "Наше обучение изначально создавалось как дистанционное",R.drawable.blogging_bro_1)
        )
        OnBoardingActivity.Viewpager.adapter = ViewPagerAdapter(list)
        OnBoardingActivity.Viewpager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if (position == 2){
                    button2.text = "Начать"
                }
                super.onPageSelected(position)
            }



        })
    }
}