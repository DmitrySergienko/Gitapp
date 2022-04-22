package ru.ds.gitapp.viewModel

import ru.ds.gitapp.model.User


    //состояние нашего приложения
    sealed class GITUserState {
        data class Success(val serverResponseData: User): GITUserState()
        data class Error(val error: Throwable): GITUserState()
        data class Loading(val progress: Int?): GITUserState()
    }
