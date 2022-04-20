package ru.ds.gitapp.model.retrofit


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.ds.gitapp.model.GitUserEntity


interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GitUserEntity>>
}