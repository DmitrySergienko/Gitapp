package ru.ds.gitapp

import android.app.Application
import android.content.Context
import ru.ds.gitapp.data.retrofit.RetrofitUsersRepoImpl
import ru.ds.gitapp.domain.remote.GitUserRep

class App : Application() {
    val gitUserRepo: GitUserRep by lazy { RetrofitUsersRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App