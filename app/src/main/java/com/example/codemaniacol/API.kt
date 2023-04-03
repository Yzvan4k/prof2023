package com.example.codemaniacol

import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("SignIn")
    fun log(@Body body: LogB):retrofit2.Call<Token>
    @POST("SignUp")
    fun reg(@Body body: RegB):retrofit2.Call<String>

}