package ru.ds.gitapp.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHolder {
    val retrofitService by lazy {
        getRetrofit()
    }

        fun getRetrofit(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
            return retrofit.create(RetrofitService::class.java)
        }

}