package ru.ds.gitapp.model

import com.google.gson.annotations.SerializedName

data class User(

    val name: String,
    val login: String,
    @SerializedName("avatar_url")
    val avatarURL: String,
    val url: String,
    @SerializedName("html_url")
    val htmlURL: String,

)
