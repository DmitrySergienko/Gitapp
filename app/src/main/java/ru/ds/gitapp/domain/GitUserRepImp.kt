package ru.ds.gitapp.domain


import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ds.gitapp.model.User
import ru.ds.gitapp.remote.RetrofitService
import ru.ds.gitapp.viewModel.GITUserState


class GitUserRepImp(
    private val retrofitService: RetrofitService,
): GitUserRep {

    private val liveData: MutableLiveData<GITUserState> = MutableLiveData()

    override fun getUsers(): Single<List<User>> {
        return retrofitService.getUsers(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        liveData.postValue(GITUserState.Success(it))
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                //TODO
            }

        })
    }
}