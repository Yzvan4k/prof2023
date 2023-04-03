package com.example.codemaniacol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
// Этот клас производит регистрирование нового аккаунта в систему
// 03.03.23
// Egor (Yzvan)
// Проверка строк на пустоту .Проверка mail на Pattern.Проверка пола.

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val UpSecondtname =findViewById<EditText>(R.id.UpLastname)
        val UpFirstname =findViewById<EditText>(R.id.UpFirstname)
        val Uppatronymic =findViewById<EditText>(R.id.Uppatronymic)
        val UpSex =findViewById<EditText>(R.id.UpSex)
        val UpdateBirthDay =findViewById<EditText>(R.id.UpdateBirthDay)
        val UpMail =findViewById<EditText>(R.id.UpMail)
        val UpPass = findViewById<EditText>(R.id.Uppass)
        val UpPass2 = findViewById<EditText>(R.id.Uppass2)
        val button8 = findViewById<Button>(R.id.button8)
        val button7 = findViewById<Button>(R.id.button7)

        button8.setOnClickListener { startActivity(Intent(this,SignIn::class.java)) }
        button7.setOnClickListener {
            val UpsecondName = UpSecondtname.text.toString()
            if (UpsecondName.isBlank()){
                error(this, "Error", "Empty Second name")
                    return@setOnClickListener }
            val UpName = UpFirstname.text.toString()
            if (UpsecondName.isBlank()){
                error(this, "Error", "Empty  name")
                return@setOnClickListener }
            val UpPatronymic = Uppatronymic.text.toString()
            if (UpPatronymic.isBlank()){
                error(this, "Error", "Empty patronymic")
                return@setOnClickListener }
            val Sex = UpSex.text.toString()
            if (Sex.isBlank()){
                error(this, "Error", "Empty sex")
                return@setOnClickListener }
            else
                if (Sex != "Мужчина" || Sex != "Женщина") {
                    error(this, "Error", "Wrong sex")
                    return@setOnClickListener
                }
                val BirthDay = UpdateBirthDay.text.toString()
                if (BirthDay.isBlank()) {
                    error(this, "Error", "Empty birth day")
                    return@setOnClickListener
                }
                val UpEmail = UpMail.text.toString()
                if (UpEmail.isBlank()) {
                    error(this, "Error", "Empty mail")
                    return@setOnClickListener
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(UpEmail).matches()) {
                    error(this, "Error", "Wrong mail")
                    return@setOnClickListener
                }
                val UpPassword = UpPass.text.toString()
                if (UpPassword.isBlank()) {
                    error(this, "Error", "Empty password")
                    return@setOnClickListener
                }

            api.reg(RegB(UpName,UpsecondName,UpPatronymic,UpEmail,UpPassword,BirthDay,Sex)).enqueue(object :retrofit2.Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.body() == "Успешно"){
                        startActivity(Intent(this@SignUp,Main::class.java))
                    }else error(this@SignUp,"Error", response.body()!!)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    error(this@SignUp, "Error", t.localizedMessage ?: t.message ?: "Unknown error")
                }
            })


    }
}}