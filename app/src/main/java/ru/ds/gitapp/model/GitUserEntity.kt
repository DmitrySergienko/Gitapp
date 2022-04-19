package ru.ds.gitapp.model

import com.google.gson.annotations.SerializedName

data class GitUserEntity(

    val name: String,
    val url: String,


    // @SerializedName("html_url")
    // val htmlURL: String,
    // val login: String,
    // @SerializedName("avatar_url")
    // val avatarURL: String,
)
