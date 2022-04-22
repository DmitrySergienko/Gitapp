package ru.ds.gitapp.data.retrofit


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.ds.gitapp.domain.remote.GitUserEntity


interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GitUserEntity>>
}