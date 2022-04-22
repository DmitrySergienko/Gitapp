package ru.ds.gitapp.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.Callback
import retrofit2.http.GET
import ru.ds.gitapp.model.User

interface RetrofitService {

    @GET("/users")
    fun getUsers(param: Callback<User>): Single<List<User>>

}