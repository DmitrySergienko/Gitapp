package ru.ds.gitapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ds.gitapp.model.User
import ru.ds.gitapp.remote.ApiHolder

class UserViewModel(
    private val liveData: MutableLiveData<GITUserState> = MutableLiveData(),
    private val userRemoteImp: ApiHolder = ApiHolder()
) : ViewModel() {
    fun getLiveData(): LiveData<GITUserState> {
        return liveData
    }

    fun sendServerRequest() {
        liveData.postValue(GITUserState.Loading(null))
        userRemoteImp.getRetrofit().getUsers(
            object : Callback<User> {
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

            }
        )

    }

}