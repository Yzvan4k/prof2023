package com.example.codemaniacol

import android.content.Context
import androidx.appcompat.app.AlertDialog
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val retrofit = Retrofit.Builder().baseUrl("http://strukov-artemii.online:8085/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api = retrofit.create(API::class.java)

fun error(context: Context, title:String, message:String){
    AlertDialog.Builder(context)
        .setNegativeButton("Попробовать снова", null)
        .setTitle(title)
        .setMessage(message)
        .show()
}

var token = ""