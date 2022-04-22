package ru.ds.gitapp.domain.remote

data class GitUserEntity(

    val name: String,
    val id: String,


    // @SerializedName("html_url")
    // val htmlURL: String,
    // val login: String,
    // @SerializedName("avatar_url")
    // val avatarURL: String,
)
