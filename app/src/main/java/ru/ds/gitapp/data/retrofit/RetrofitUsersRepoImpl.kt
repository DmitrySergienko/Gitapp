package ru.ds.gitapp.data.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ds.gitapp.data.remote.GitUserEntity
import ru.ds.gitapp.data.remote.GitUserRep

//Именно эту имплементацию (retrofit) в App
class RetrofitUsersRepoImpl(
private val api:GitHubApi
) : GitUserRep {


    override fun getUsers(username: String): Single<List<GitUserEntity>> {
        return Single.create { emitter ->
            api.accountList()
                .enqueue(object : Callback<List<GitUserEntity>> {
                    override fun onResponse(
                        call: Call<List<GitUserEntity>>,
                        response: Response<List<GitUserEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitUserEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }
    override fun getUsersRep(username: String): Single<List<GitUserEntity>> {
        return Single.create { emitter ->
            api.listRepos(username)
                .enqueue(object : Callback<List<GitUserEntity>> {
                    override fun onResponse(
                        call: Call<List<GitUserEntity>>,
                        response: Response<List<GitUserEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitUserEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }


}