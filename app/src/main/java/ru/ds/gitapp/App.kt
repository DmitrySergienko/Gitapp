package ru.ds.gitapp

import android.app.Application
import android.content.Context
import ru.ds.gitapp.domain.GitUserRep
import ru.ds.gitapp.model.MockProjectsRepoImpl

class App : Application() {
    val gitUserRepo: GitUserRep by lazy { MockProjectsRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App