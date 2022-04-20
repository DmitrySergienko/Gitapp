package ru.ds.gitapp.viewModel

import ru.ds.gitapp.domain.remote.GitUserEntity


    //состояние нашего приложения
    sealed class GITUserState {
        data class Success(val serverResponseData: GitUserEntity): GITUserState()
        data class Error(val error: Throwable): GITUserState()
        data class Loading(val progress: Int?): GITUserState()
    }
