package com.example.codemaniacol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity() {
    val button3 = findViewById<Button>(R.id.button3)
    val button4 = findViewById<Button>(R.id.button4)
    val editInMail = findViewById<EditText>(R.id.editInMail)
    val editInPass = findViewById<EditText>(R.id.editInPass)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        button4.setOnClickListener {
            startActivity(Intent(this@SignIn,SignUp::class.java))
        }

        button3.setOnClickListener {
            val InMail = editInMail.text.toString()
            if (InMail.isEmpty()) {
                error(this, "Error", "Wrong mail")
                return@setOnClickListener
            }else{
                if (Patterns.EMAIL_ADDRESS.matcher(InMail).matches()){
                    error(this,"Error","Wrong mail")
                    return@setOnClickListener
                }
            }
            val InPass = editInPass.text.toString()
            if (InPass.isEmpty()){
                error(this, "Error", "Wrong password")
                return@setOnClickListener
            }
            api.log(LogB(InMail,InPass)).enqueue(object :Callback<Token>{
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if (response.isSuccessful&& response.body()!=null){
                        token = response.body()!!.token.toString()
                        startActivity(Intent(this@SignIn,Main::class.java))
                        error(this@SignIn,"Token",response.body()!!.token.toString()) }
                    else error(this@SignIn,"Error","Unknown Error")
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    error(this@SignIn,"Error",t.localizedMessage?:t.message?:"Unknown error")
                }

            })
        }
    }
}