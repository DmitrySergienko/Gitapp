package ru.ds.gitapp.data.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.domain.GitHubRep

//Именно эту имплементацию (retrofit) в App
class RetrofitRepositoryImpl(
private val api:GitHubApi
) : GitHubRep {


    override fun getUsers(username: String): Single<List<GitHubEntity>> {
        return Single.create { emitter ->
            api.accountList()
                .enqueue(object : Callback<List<GitHubEntity>> {
                    override fun onResponse(
                        call: Call<List<GitHubEntity>>,
                        response: Response<List<GitHubEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitHubEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }
    override fun getRepOfUser(username: String): Single<List<GitHubEntity>> {
        return Single.create { emitter ->
            api.listRepos(username)
                .enqueue(object : Callback<List<GitHubEntity>> {
                    override fun onResponse(
                        call: Call<List<GitHubEntity>>,
                        response: Response<List<GitHubEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitHubEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }


}