package ru.ds.gitapp.data.remote

import com.google.gson.annotations.SerializedName

data class GitUserEntity(

    val name: String,
    val id: String,
    @SerializedName("avatar_url")
    val avatarUrl: String


    // @SerializedName("html_url")
    // val htmlURL: String,
    // val login: String,

)