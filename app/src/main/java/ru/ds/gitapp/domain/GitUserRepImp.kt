package ru.ds.gitapp.domain


import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ds.gitapp.model.GitUserEntity
import ru.ds.gitapp.remote.RetrofitService
import ru.ds.gitapp.viewModel.GITUserState

/*
class GitUserRepImp(
    private val retrofitService: RetrofitService,
): GitUserRep {

    private val liveData: MutableLiveData<GITUserState> = MutableLiveData()

    override fun getUsers(): Single<List<GitUserEntity>> {
        return retrofitService.getUsers(object : Callback<GitUserEntity> {
            override fun onResponse(
                call: Call<GitUserEntity>,
                response: Response<GitUserEntity>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        liveData.postValue(GITUserState.Success(it))
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<GitUserEntity>, t: Throwable) {
                //TODO
            }

        })
    }
}*/