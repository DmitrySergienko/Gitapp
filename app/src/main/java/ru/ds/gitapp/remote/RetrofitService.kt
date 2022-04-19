package ru.ds.gitapp.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.Callback
import retrofit2.http.GET
import ru.ds.gitapp.model.GitUserEntity

interface RetrofitService {

    @GET("/users")
    fun getUsers(param: Callback<GitUserEntity>): Single<List<GitUserEntity>>

}